<?php

require 'database/Connection.php';

class ClientModel
{
  private $conn = null;
  public $primary_key = null;

  function __construct()
  {
    $this->conn = (new Connection())->create();
  }

  public function index()
  {
    $sql = 'SELECT * FROM clients';
    $stmt = $this->conn->prepare($sql);
    $stmt->execute();
    return $stmt->fetchAll();
  }
  public function getById(int $id)
  {
    $sql = 'SELECT * FROM clients WHERE idClient=?';
    $stmt = $this->conn->prepare($sql);
    $stmt->bindParam(1, $id);
    $stmt->execute();
    return $stmt->fetch();
  }
  public function store(array $client): bool
  {
    $sql = 'INSERT INTO clients (`name`,`email`,`phone`,`address`) VALUES (?,?,?,?)';
    $stmt = $this->conn->prepare($sql);
    $stmt->bindParam(1, $client['name']);
    $stmt->bindParam(2, $client['email']);
    $stmt->bindParam(3, $client['phone']);
    $stmt->bindParam(4, $client['address']);
    $res = $stmt->execute();
    if ($res)
      $this->primary_key = $this->conn->lastInsertId();
    return $res;
  }
  public function update(int $id, array $client): bool
  {
    $sql = 'UPDATE clients SET `name`=? ,`email`=? ,`phone`=? ,`address`=? WHERE idClient=?';
    $stmt = $this->conn->prepare($sql);
    $stmt->bindParam(1, $client['name']);
    $stmt->bindParam(2, $client['email']);
    $stmt->bindParam(3, $client['phone']);
    $stmt->bindParam(4, $client['address']);
    $stmt->bindParam(5, $id);
    $res = $stmt->execute();
    if ($res)
      $this->primary_key = $id;
    return $res;
  }
  public function delete(int $id): bool
  {
    $sql = 'DELETE FROM clients WHERE idClient=?';
    $stmt = $this->conn->prepare($sql);
    $stmt->bindParam(1, $id);
    return $stmt->execute();
  }
}
