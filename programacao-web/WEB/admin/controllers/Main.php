<?php

class MainController
{
  private $logged = null;
  function __get($attr)
  {
    return $this->$attr;
  }

  function __construct()
  {
    if (isset($_SESSION['user']))
      $this->logged = $_SESSION['user']['logged'];
  }


  public function index(string $view, string $title)
  {
    require 'views/main.php';
  }
}
