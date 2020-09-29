<?php

namespace App\ControlRoute;

class Middleware
{
    public $middleware = [];
    public $response;
    public $request;

    function __construct($request, $response)
    {
        $this->request  = $request;
        $this->response = $response;
    }

    public function use($middleware)
    {
        array_push($this->middleware, $middleware);
    }

    public function middleware()
    {
        foreach ($this->middleware as $key => $value) {
            $this->middleware[$key]($this->request, $this->response);
        }
    }
}
