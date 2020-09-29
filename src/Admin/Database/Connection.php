<?php

namespace App\Admin\Database;

class Connection
{
    private static $conn;

    public function create()
    {
        try {
            self::$conn = new \PDO('mysql:host=localhost;dbname=pw_exemple', 'admin', '12345678');
        } catch (\PDOException $err) {
            die("Erro: <code>" . $err->getMessage() . "<code>");
        }
        return self::$conn;
    }

    public function disconnect()
    {
        $this->conn = null;
    }
}
