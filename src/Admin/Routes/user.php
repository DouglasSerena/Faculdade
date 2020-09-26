<?php

namespace App\Admin\Routes;

use App\Admin\Controllers\UserController;
use App\Admin\Controllers\MainController;

// middleware
$app->use(function ($req, $res) {
    $res->setView('src/Admin/views');
});

$app->get("/pw2/login", function ($req, $res) {
    if ($req::getSession('logged') && $req::getSession('logged')['permission'])
        return $res->redirect('/pw2/admin');
    $res->render('user/form');
});
// logar
$app->post("/pw2/login", function ($req, $res) {
    (new UserController())->signin($req, $res);
});

$app->use(function ($req, $res) {
    if (!$req::getSession('logged'))
        return $res->redirect('/pw2/login?message=Você deve se logar.&type=primary');
    if (!$req::getSession('logged')['permission'])
        return $res->redirect('/pw2/login?message=Você não tem autorização.&type=primary');
});

$app->get("/pw2/admin/logout", function ($req, $res) {
    (new UserController())->logout($req, $res);
});

$app->get("/pw2/admin", function ($req, $res) {
    (new MainController())->index($req, $res);
});

require 'src/Admin/Routes/client.php';
require 'src/Admin/Routes/product.php';
