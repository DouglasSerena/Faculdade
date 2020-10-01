<?php
session_start();

require 'controllers/Main.php';
require '../config/config.php';
env('../config/.env');

$main = new MainController();

if (!$main->logged) {
  require 'controllers/User.php';
  $user = new UserController();
  return $user->login('user/login');
}

// VERIFY EXIST CONTROL
if (!isset($_GET['control']))
  return $main->index('admin/index', 'Admin');

switch ($_REQUEST['control']) {
  case 'main':
    // VERIFY EXIST ACTION
    if (!isset($_GET['action']))
      return $main->index('admin/index', 'Admin');

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'index':
        return $main->index('admin/index', 'Admin');
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
      case 'store':
        return $client->store('client/store', 'Client | Store');
      case 'update':
        return $client->update('client/update', 'Client | Update');
      case 'delete':
        return $client->delete();
    }
  case 'user':
    require 'controllers/User.php';
    $user = new UserController();

    // VERIFY EXIST ACTION
    if (!isset($_GET['action']))
      return $main->index('admin/index', 'Admin');

    // CONTROLLER DE ACTION
    switch ($_REQUEST['action']) {
      case 'index':
        return $main->index('admin/index', 'Admin');
      case 'logout':
        return $user->logout();
    }
}
