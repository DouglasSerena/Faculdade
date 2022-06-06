<?php

require 'database/Connection.php';

class ProductModel
{
  private $conn = null;

  function __construct()
  {
    $this->conn = (new Connection())->create();
  }

  public function index()
  {
    $sql = 'SELECT * FROM products';
    $stmt = $this->conn->prepare($sql);
    $stmt->execute();
    return $stmt->fetchAll();
  }
}
