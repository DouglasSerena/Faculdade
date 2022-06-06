<?php

class Connection
{
  private static $conn;

  function create(): PDO
  {
    if (self::$conn)
      return self::$conn;
    try {
      self::$conn = new \PDO(
        "{$_ENV['DB_DRIVE']}:
        host={$_ENV['DB_HOST']};
        dbname={$_ENV['DB_NAME']}",
        $_ENV['DB_USER'],
        $_ENV['DB_PASS']
      );
    } catch (Exception $err) {
      echo $err->getMessage();
      exit;
    }
    return self::$conn;
  }

  function __get($attr): PDO
  {
    return $this->$attr;
  }

  public function disconnect()
  {
    self::$conn = null;
  }
}
