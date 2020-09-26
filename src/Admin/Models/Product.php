<?php

namespace App\Admin\Models;

use App\Admin\Database\Connection;

class Product
{
  private static $conn;

  function __construct()
  {
    self::$conn = (new Connection())->create();
  }


  public function create(array $data)
  {
    $sql = "INSERT INTO `products` (`idProduct`, `name`, `price`, `description`, `idCategory`) VALUES (NULL, ?, ?, ?, ?)";
    $stmt = self::$conn->prepare($sql);
    $stmt->bindParam(1, $data['name']);
    $stmt->bindParam(2, $data['price']);
    $stmt->bindParam(3, $data['description']);
    $stmt->bindParam(4, $data['category']);
    return $stmt->execute();
  }
}
