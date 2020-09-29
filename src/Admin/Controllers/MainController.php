<?php

namespace App\Admin\Controllers;

use App\ControlRoute\Response;
use App\ControlRoute\Request;
use App\Admin\Models\User;

class MainController
{
  public function index(Request $req, Response $res)
  {
    $res->render('index');
  }
}
