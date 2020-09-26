<?php

namespace App\Admin\Routes;

use App\Admin\Controllers\UserController;
use App\Admin\Controllers\MainController;

// middleware
$app->use(function ($req, $res) {
    $res->setView('src/Admin/views');
});

$app->get("/ULBRA_FACUDADE/login", function ($req, $res) {
    if ($req::getSession('logged') && $req::getSession('logged')['permission'])
        return $res->redirect('/ULBRA_FACUDADE/admin');
    $res->render('user/form');
});
// logar
$app->post("/ULBRA_FACUDADE/login", function ($req, $res) {
    (new UserController())->signin($req, $res);
});

$app->use(function ($req, $res) {
    if (!$req::getSession('logged'))
        return $res->redirect('/ULBRA_FACUDADE/login?message=Você deve se logar.&type=primary');
    if (!$req::getSession('logged')['permission'])
        return $res->redirect('/ULBRA_FACUDADE/login?message=Você não tem autorização.&type=primary');
});

$app->get("/ULBRA_FACUDADE/admin/logout", function ($req, $res) {
    (new UserController())->logout($req, $res);
});

$app->get("/ULBRA_FACUDADE/admin", function ($req, $res) {
    (new MainController())->index($req, $res);
});

require 'src/Admin/Routes/client.php';
require 'src/Admin/Routes/product.php';
