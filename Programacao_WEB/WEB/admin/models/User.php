<?php

require 'database/Connection.php';

class UserModel
{
  private $conn = null;

  function __construct()
  {
    $this->conn = (new Connection())->create();
  }

  public function getById(int $id)
  {
    $sql = 'SELECT * FROM users WHERE idUser=?';
    $stmt = $this->conn->prepare($sql);
    $stmt->bindParam(1, $id);
    $stmt->execute();
    return $stmt->fetch();
  }
  public function getBy(string $search, string $value)
  {
    $sql = "SELECT * FROM users WHERE {$search}=?";
    $stmt = $this->conn->prepare($sql);
    $stmt->bindParam(1, $value);
    $stmt->execute();
    return $stmt->fetch();
  }
}
