<?php

require 'database/Connection.php';
require 'config/config.php';
require 'Token.php';

env('config/.env');

header('Content-type: application/json');

// VERIFY EXIST CONTROL
if (!isset($_GET['control'])) {
  echo 'falha sem control';
  return error("Deve haver o parâmetro ('control').");
}

// VERIFY EXIST ACTION
if (!isset($_GET['action']))
  return error("Deve haver o parâmetro ('action').");


switch ($_REQUEST['control']) {
    /*********** ADMIN ***********/
  case 'user':
    require 'app/UserController.php';
    $user = new UserController();

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'login':
        return $user->login();
    }

    /*********** ADMIN ***********/

  case 'client':
    if (!Token::valid()) {
      http_response_code(403);
      return print(json_encode([
        'status' => 403,
        'access' => false,
        'message' => "Você não tem autorização para acessar este conteúdo."
      ]));
    }

    require 'app/ClientController.php';
    $client = new ClientController();

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'index':
        return $client->index();
      case 'getById':
        return $client->getById();
      case 'store':
        return $client->store();
      case 'update':
        return $client->update();
      case 'delete':
        return $client->delete();
    }
}

function error(string $message)
{
  http_response_code(400);
  print(json_encode([
    'status' => 400,
    'error' => false,
    'message' => $message
  ]));
}
