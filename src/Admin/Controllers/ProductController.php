<?php

namespace App\Admin\Controllers;

use App\ControlRoute\Request;
use App\ControlRoute\Response;
use App\Admin\Models\Product;

class ProductController
{
  public $Product;

  function __construct()
  {
    $this->Product = new Product();
  }

  public function create(Request $req, Response $res)
  {
    $response = $this->Product->create($req::$body);
    if ($response) {
      return $res->redirect('/ULBRA_FACUDADE/admin/product/create?message=Produto criado como sucesso.&type=success');
    }
    return $res->redirect('/ULBRA_FACUDADE/admin/product/create?message=Ocorreu um erro ao salvar o produto. Tente novamente.&type=danger');
  }
}
