<?php

require 'models/Product.php';

class ProductController
{
  public function index(string $view, string $title)
  {
    $productModal = new ProductModel();
    $products = $productModal->index();
    if (!$products)
      return print("error");
    require 'views/main.php';
  }
}
