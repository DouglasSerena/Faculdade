<?php
session_start();

require 'controllers/Main.php';
require 'config/config.php';
env('config/.env');

$main = new MainController();

// VERIFY EXIST CONTROL
if (!isset($_GET['control']))
  return $main->index('main/index', 'Home');

switch ($_REQUEST['control']) {
  case 'main':
    // VERIFY EXIST ACTION
    if (!isset($_GET['action']))
      return $main->index('main/index', 'Home');

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'index':
        return $main->index('main/index', 'Home');
    }
  case 'client':
    require 'controllers/Client.php';
    $client = new ClientController();

    // VERIFY EXIST ACTION
    if (!isset($_GET['action']))
      return $client->index('client/index', 'Client');

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'index':
        return $client->index('client/index', 'Client');
    }
  case 'product':
    require 'controllers/Product.php';
    $product = new ProductController();

    // VERIFY EXIST ACTION
    if (!isset($_GET['action']))
      return $product->index('product/index', 'Product');

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'index':
        return $product->index('product/index', 'Product');
    }
}
