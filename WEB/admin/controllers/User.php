<?php

class UserController
{
  public function login(string $view)
  {
    if ($_SERVER['REQUEST_METHOD'] === 'POST')
      return $this->loginAction();
    require "views/$view.php";
  }

  public function logout()
  {
    session_destroy();
    header('Location: /ULBRA_FACUDADE');
  }

  public function loginAction()
  {
    require 'models/User.php';
    $userModel = new UserModel();
    $user = $userModel->getBy('user', $_POST['user']);
    if ($user['user'] == $_POST['user'])
      if ($user['password'] == $_POST['password']) {
        $_SESSION['user'] = array(
          'logged' => true,
          'name' => $user['name'],
          'user' => $user['user']
        );
        return header('Location: ?message=Logged with success&type=success');
      }
    header('Location: ?message=User and password invalids&type=danger');
  }
}
