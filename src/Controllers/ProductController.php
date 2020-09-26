<?php

namespace App\Controllers;

use App\ControlRoute\Request;
use App\ControlRoute\Response;
use App\Models\Product;

class ProductController
{
    public $Product;

    function __construct()
    {
        $this->Product = new Product();
    }

    public function index(Request $req, Response $res)
    {
        $products = $this->Product->index();
        $res->render('product/index', $products);
    }
}
