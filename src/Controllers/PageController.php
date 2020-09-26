<?php

namespace App\Controllers;

use App\ControlRoute\Request;
use App\ControlRoute\Response;

class PageController
{
    public function home(Request $req, Response $res)
    {
        $res->render('page/home');
    }
    public function about(Request $req, Response $res)
    {
        $res->render('page/about');
    }
}
