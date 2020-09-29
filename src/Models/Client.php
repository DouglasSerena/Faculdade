<?php

namespace App\Models;

use App\Database\Connection;

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
}
