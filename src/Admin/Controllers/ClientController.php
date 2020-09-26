<?php

namespace App\Admin\Controllers;

use App\Admin\Models\Client;
use App\ControlRoute\Request;
use App\ControlRoute\Response;

class ClientController
{
  public $Client;
  function __construct()
  {
    $this->Client = new Client();
  }

  public function index(Request $req, Response $res)
  {
    $clients = $this->Client->index();
    $res->render('client/index', $clients);
  }

  public function store(Request $req, Response $res)
  {
    $response = $this->Client->store($req::$body);
    if ($response) {
      return $res->redirect('/pw2/admin/client?message=Cliente criado como sucesso.&type=success');
    }
    return $res->redirect('/pw2/admin/client/store?message=Ocorreu um erro ao salvar o cliente. Tente novamente.&type=danger');
  }

  public function getById(Request $req, Response $res)
  {
    $client = $this->Client->getById($req::$params['id']);
    if ($client) {
      return $res->json($client);
    }
    return $res->json([]);
  }

  public function update(Request $req, Response $res)
  {
    $response = $this->Client->update($req::$body);
    if ($response) {
      return $res->redirect('/pw2/admin/client?message=Cliente atualizado como sucesso.&type=success');
    }
    return $res->redirect('/pw2/admin/client/update/' . $req::$body['id'] . '?message=Ocorreu um erro ao atualizar o cliente. Tente novamente.&type=danger');
  }

  public function delete(Request $req, Response $res)
  {
    $response = $this->Client->delete($req::$params['id']);
    if ($response) {
      return $res->redirect('/pw2/admin/client?message=Cliente deletado como sucesso.&type=primary');
    }
    return $res->redirect('/pw2/admin/client/update/' . $req::$body['id'] . '?message=Ocorreu um erro ao deletar o cliente. Tente novamente.&type=danger');
  }
}
