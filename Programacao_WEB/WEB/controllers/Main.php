<?php

class MainController
{
  public function index(string $view, string $title)
  {
    require 'views/main.php';
  }
}
