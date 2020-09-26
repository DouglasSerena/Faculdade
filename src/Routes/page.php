<?php

namespace App\Routes;

use App\Controllers\PageController;

// pages
$app->get('/pw2/', function ($req, $res) {
    (new PageController())->home($req, $res);
});
$app->get('/pw2/about', function ($req, $res) {
    (new PageController())->about($req, $res);
});
