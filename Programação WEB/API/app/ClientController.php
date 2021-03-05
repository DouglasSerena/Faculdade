<?php

require 'models/ClientModel.php';

class ClientController
{
  private ClientModel $clientModel;

  function __construct()
  {
    $this->clientModel = new ClientModel();
  }

  function index()
  {
    $client = $this->clientModel->index();
    if (!!$client) {
      return print(json_encode(['status' => 200, 'clients' => $client]));
    }
    http_response_code(500);
    echo json_encode([
      'status' => 500,
      'error' => true,
      'message' => 'Hove algum erro ao buscar os clientes.'
    ]);
  }
  function getById()
  {
    $client = $this->clientModel->getById($_GET['id']);
    if (!!$client) {
      return print(json_encode(['status' => 200, 'client' => $client]));
    } else {
      http_response_code(400);
      echo json_encode([
        'status' => 400,
        'error' => true,
        'message' => "Cliente {$_REQUEST['id']} não existe. Tente novamente."
      ]);
    }
  }
  function store()
  {
    $client = json_decode(file_get_contents('php://input'));
    $res = $this->clientModel->store($client);
    if ($res) {
      http_response_code(201);
      return print(json_encode([
        'status' => 201,
        'id' => $this->clientModel->primary_key
      ]));
    }
    http_response_code(400);
    echo json_encode([
      'status' => 400,
      'error' => true,
      'message' => "Hove um error no cadastro. Tente novamente."
    ]);
  }
  function update()
  {
    $client = json_decode(file_get_contents('php://input'));
    $clientExist = $this->clientModel->getById($_REQUEST['id']);
    if (!!$clientExist) {
      $res = $this->clientModel->update($_GET['id'], $client);
      if (!!$res) {
        return print(json_encode([
          'status' => 201,
          'client' => $this->clientModel->getById($_REQUEST['id'])
        ]));
      } else {
        http_response_code(400);
        echo json_encode([
          'status' => 400,
          'error' => true,
          'message' => "Hove um error no atualizar o cliente {$_REQUEST['id']}. Tente novamente."
        ]);
      }
    } else {
      http_response_code(400);
      echo json_encode([
        'status' => 400,
        'error' => true,
        'message' => "Cliente {$_REQUEST['id']} não existe. Tente novamente."
      ]);
    }
  }
  function delete()
  {
    $clientExist = $this->clientModel->getById($_REQUEST['id']);
    if (!!$clientExist) {
      $res = $this->clientModel->delete($_GET['id']);
      if ($res) {
        return print(json_encode(['status' => 201, 'id' => $_REQUEST['id']]));
      } else {
        http_response_code(400);
        echo json_encode([
          'status' => 400,
          'error' => true,
          'message' => "Hove um error ao deletar o cliente {$_REQUEST['id']}. Tente novamente."
        ]);
      }
    } else {
      http_response_code(400);
      echo json_encode([
        'status' => 400,
        'error' => true,
        'message' => "Cliente {$_REQUEST['id']} não existe. Tente novamente."
      ]);
    }
  }
}
