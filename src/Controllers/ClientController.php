<?php

namespace App\Controllers;

use App\Models\Client;
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
}
