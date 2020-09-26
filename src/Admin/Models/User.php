<?php

namespace App\Admin\Models;

use App\Admin\Database\Connection;

class User
{
    public $conn;

    public function __construct()
    {
        $this->conn = (new Connection())->create();
    }

    public function getUser(string $user)
    {
        $sql = "SELECT * FROM users WHERE user=?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bindParam(1, $user);
        $stmt->execute();
        return $stmt->fetch();
    }
}
