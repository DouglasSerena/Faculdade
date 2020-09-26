<?php

namespace App\Database;

class Connection
{
    private static $conn = null;

    public function create()
    {
        if (!isset(self::$conn)) {
            try {
                self::$conn = new \PDO('mysql:host=localhost;dbname=pw_exemple', 'admin', 'admin123');
            } catch (\PDOException $err) {
                die("Erro: <code>" . $err->getMessage() . "<code>");
            }
        }
        return self::$conn;
    }

    public function disconnect()
    {
        $this->conn = null;
    }
}
