<?php

require 'models/Client.php';

class ClientController
{
  public function index(string $view, string $title)
  {
    $clientModal = new ClientModel();
    $clients = $clientModal->index();
    require 'views/main.php';
  }
}
