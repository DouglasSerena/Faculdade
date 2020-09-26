<?php

namespace App\Models;

use App\Database\Connection;

class Product
{
    private static $conn;

    function __construct()
    {
        self::$conn = (new Connection())->create();
    }

    public function  index()
    {
        $sql = "SELECT * FROM products";
        $stmt = self::$conn->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }
}
