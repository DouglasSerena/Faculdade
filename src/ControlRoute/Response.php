<?php

namespace App\ControlRoute;

class Response
{
    private static $pathViews = "src/views";
    public $Request;

    function __construct()
    {
        $this->Request = new Request();
    }

    public function setView($path)
    {
        self::$pathViews = $path;
    }

    public function render(string $file, $datas = array())
    {
        $params = $this->Request::$params;
        $query = $this->Request::$query;
        $body = $this->Request::$body;
        $url = $this->Request::$url;
        $session = $_SESSION;
        if (file_exists(self::$pathViews . '/main.php')) {
            $content = self::$pathViews . "/$file.php";
            return require_once(self::$pathViews . '/main.php');
        }
        if (file_exists(self::$pathViews . "/$file.php"))
            return require_once(self::$pathViews . "/$file.php");
        echo "File not found. " . self::$pathViews . "/$file.php";
    }

    public function redirect($path)
    {
        header("Location: http://localhost" . $path);
    }

    public function send(string $text)
    {
        echo $text;
    }

    public function json(array $json)
    {
        echo json_encode($json);
    }
}
