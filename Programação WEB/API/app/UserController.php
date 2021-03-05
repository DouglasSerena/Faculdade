<?php

require 'models/UserModel.php';

class UserController
{
  private UserModel $userModel;

  function __construct()
  {
    $this->userModel = new UserModel();
  }

  public function login()
  {
    $user = json_decode(file_get_contents('php://input'));
    $res = $this->userModel->getBy('user', $user->user);
    if ($res) {
      if ($res['user'] === $user->user) {
        if ($res['password'] == $user->password) {
          $token = Token::create(
            $res['name'],
            !!$res['admin'],
          );
          return print(json_encode(['status' => 200, 'access' => true, 'token' => $token]));
        }
      }
    }
    http_response_code(400);
    print(json_encode([
      'status' => 400,
      'access' => false,
      'message' => "User ou Senha invalido."
    ]));
  }
}
