<?php

namespace App\Routes;

use App\Controllers\PageController;

// pages
$app->get('/ULBRA_FACUDADE/', function ($req, $res) {
    (new PageController())->home($req, $res);
});
$app->get('/ULBRA_FACUDADE/about', function ($req, $res) {
    (new PageController())->about($req, $res);
});
