<?php

namespace App\ControlRoute;

class App
{
    private static $running = true;
    public $Response;
    public $Request;
    public $method;
    public $route;

    function __construct()
    {
        $REQUEST_URL = filter_input(INPUT_SERVER, 'REQUEST_URI');
        $URL = explode('?', $REQUEST_URL);
        $this->route = $URL[0];
        $this->method = $_SERVER['REQUEST_METHOD'];
        $this->Request  = new Request($this->route);
        $this->Response = new Response();
        $this->middleware = new Middleware($this->Request, $this->Response);
    }

    public function get(string $path, $cb): void
    {
        if ($this->method === 'GET')
            $this->response($path, $cb);
    }

    public function post(string $path, $cb): void
    {
        if ($this->method === 'POST')
            $this->response($path, $cb);
    }

    public function delete(string $path, $cb): void
    {
        if ($this->method === 'DELETE')
            $this->response($path, $cb);
    }

    public function put(string $path, $cb): void
    {
        if ($this->method === 'PUT')
            $this->response($path, $cb);
    }

    public function use($middleware): void
    {
        $this->middleware->use($middleware);
    }

    private function notFound($path, $cb)
    {
        if ($path === "**" && self::$running) {
            return $cb($this->Request, $this->Response);
        }
    }

    private function response(string $path, $cb)
    {
        $datas = $this->REQUEST_URL($path, $this->route);
        if ($datas['url'] === $this->route && self::$running) {
            $this->Request::$params = $datas['params'];
            self::$running = false;
            $this->middleware->middleware();
            return $cb($this->Request, $this->Response);
        }
        $this->notFound($path, $cb);
    }

    private function REQUEST_URL($path, $url)
    {
        $datas = ['params' => [], 'url' => []];
        $arrayUrl = explode('/', $url);
        if (strstr($path, ':')) {
            foreach (explode('/', $path) as $key => $value) {
                if (strstr($value, ':') && isset($arrayUrl[$key])) {
                    $datas['url'][$key] = $arrayUrl[$key];
                    $datas['params'] += $this->Request->filter(array(substr($value, 1) => $arrayUrl[$key]));
                } else {
                    $datas['url'][$key] = $value;
                }
            }
            $datas['url'] = implode('/', $datas['url']);
            return $datas;
        }
        $datas['url'] = $path;
        return $datas;
    }
}
