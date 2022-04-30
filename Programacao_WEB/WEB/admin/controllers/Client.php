<?php

require 'models/Client.php';
require 'models/File.php';

class ClientController
{
  public function index(string $view, string $title)
  {
    $clientModal = new ClientModel();
    $clients = $clientModal->index();
    require 'views/main.php';
  }

  public function getById()
  {
    $clientModal = new ClientModel();
    return $clientModal->getById($_GET['id']);
  }

  public function store(string $view, string $title)
  {
    if ($_SERVER['REQUEST_METHOD'] === 'POST')
      return $this->storeAction();
    require 'views/main.php';
  }

  private function storeAction()
  {
    $clientModal = new ClientModel();
    $store = $clientModal->store($_POST);
    if ($store) {
      if ($_FILES['photo']) (new FileModel)
        ->upload(
          $_FILES['photo'],
          $clientModal->primary_key,
          '../tmp/uploads/clients'
        );
      return header('Location: ?control=client&action=index&message=Client store with success.&type=success');
    }
    header('Location: ?control=client&action=store&message=Error store client.&type=danger');
  }

  public function update(string $view, string $title)
  {
    if ($_SERVER['REQUEST_METHOD'] === 'POST')
      return $this->updateAction();
    $client = $this->getById();
    require 'views/main.php';
  }

  private function updateAction()
  {
    $clientModal = new ClientModel();
    $update = $clientModal->update($_GET['id'], $_POST);
    if ($update) {
      if ($_FILES['photo']) (new FileModel)
        ->upload(
          $_FILES['photo'],
          $clientModal->primary_key,
          '../tmp/uploads/clients'
        );
      return header('Location: ?control=client&action=index&message=Client update with success&type=success');
    }
    header('Location: ?control=client&action=update&message=Error update client.&type=danger');
  }

  public function delete()
  {
    $clientModal = new ClientModel();
    $delete = $clientModal->delete($_GET['id']);
    (new FileModel)->remove($_GET['id'], '../tmp/uploads/clients');
    if ($delete)
      return header('Location: ?control=client&action=index&message=Client delete with success.&type=success');
    header('Location: ?control=client&action=index&message=Error delete client.&type=danger');
  }
}
