<?php

namespace App\Admin\Controllers;

use App\ControlRoute\Response;
use App\ControlRoute\Request;
use App\Admin\Models\User;

class UserController
{
  private $user;

  public function __construct()
  {
    $this->user = new User();
  }

  public function signin(Request $req, Response $res)
  {
    $user = $this->user->getUser($req::$body['user']);
    if ($user['user'] === $req::$body['user']) {
      if ($user['password'] === $req::$body['password']) {
        $req::setSession('logged', array('user' => $req::$body['user'], 'permission' => $user['admin']));
        return $res->redirect('/pw2/admin?message=Logado com sucesso.&type=success');
      }
      return $res->redirect('/pw2/login?message=Senha diferente do Usuário.&type=danger');
    }
    return $res->redirect('/pw2/login?message=Usuário não encontrado.&type=danger');
  }

  public function logout(Request $req, Response $res)
  {
    session_destroy();
    return $res->redirect('/pw2/');
  }
}
