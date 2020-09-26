<?php

namespace App\ControlRoute;

class Request
{
    public static $params = [];
    public static $query = [];
    public static $body = [];
    public static $url;

    function __construct(string $url = null)
    {
        self::$query = $this->filter($_GET);
        self::$body = $this->filter($_POST);
        if ($url)
            self::$url = $url;
        self::startSession();
    }

    public function filter(array $var)
    {
        $dest = array();
        foreach ($var as $key => $value) {
            switch (gettype($value)) {
                case 'string':
                    $dest[$key] = filter_var($value, FILTER_SANITIZE_STRING);
                    break;
                case 'int':
                    $dest[$key] = filter_var($value, FILTER_SANITIZE_NUMBER_INT);
                    break;
                case 'float':
                    $dest[$key] = filter_var($value, FILTER_SANITIZE_NUMBER_FLOAT);
                    break;
                default:
                    $dest[$key] = $value;
                    break;
            }
        }
        return $dest;
    }

    public static function getSession($key)
    {
        if (isset($_SESSION[$key])) {
            return $_SESSION[$key];
        }
        return false;
    }
    public static function setSession($key, $value)
    {
        $_SESSION[$key] = $value;
    }

    private static function startSession()
    {
        if (!isset($_SESSION))
            session_start();
    }
}
