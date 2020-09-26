<?php

namespace App\Admin\Models;

use App\Admin\Database\Connection;

class Client
{
  private static $conn;

  function __construct()
  {
    self::$conn = (new Connection())->create();
  }

  public function  index()
  {
    $sql = "SELECT * FROM clients";
    $stmt = self::$conn->prepare($sql);
    $stmt->execute();
    return $stmt->fetchAll();
  }
  public function getById($id)
  {
    $sql = "SELECT * FROM clients WHERE idClient=?";
    $stmt = self::$conn->prepare($sql);
    $stmt->bindParam(1, $id);
    $stmt->execute();
    return $stmt->fetch();
  }

  public function update(array $data)
  {
    $sql = "UPDATE `clients` SET `name`=?, `phone`=?, `email`=?, `address`=?
            WHERE idClient=?;";
    $stmt = self::$conn->prepare($sql);
    $stmt->bindParam(1, $data['name']);
    $stmt->bindParam(2, $data['phone']);
    $stmt->bindParam(3, $data['email']);
    $stmt->bindParam(4, $data['address']);
    $stmt->bindParam(5, $data['id']);
    return $stmt->execute();
  }

  public function delete($id)
  {
    $sql = "DELETE FROM clients WHERE idClient=?";
    $stmt = self::$conn->prepare($sql);
    $stmt->bindParam(1, $id);
    return $stmt->execute();
  }

  public function store(array $data)
  {
    $sql = "INSERT INTO `clients` (`idClient`, `name`, `phone`, `email`, `address`)
              VALUES (NULL, ?, ?, ?, ?);";
    $stmt = self::$conn->prepare($sql);
    $stmt->bindParam(1, $data['name']);
    $stmt->bindParam(2, $data['phone']);
    $stmt->bindParam(3, $data['email']);
    $stmt->bindParam(4, $data['address']);
    return $stmt->execute();
  }
}
