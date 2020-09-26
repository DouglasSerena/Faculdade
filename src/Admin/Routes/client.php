<?php

namespace App\Admin\Routes;

use App\Admin\Controllers\ClientController;

// clients
$app->get("/pw2/admin/client", function ($req, $res) {
  (new ClientController())->index($req, $res);
});
$app->get('/pw2/admin/client/store', function ($req, $res) {
  $res->render('client/store');
}); // render file
$app->get('/pw2/admin/client/update/:id', function ($req, $res) {
  $res->render('client/update');
}); // render file
$app->get("/pw2/admin/client/:id", function ($req, $res) {
  (new ClientController())->getById($req, $res);
});
$app->get('/pw2/admin/client/delete/:id', function ($req, $res) {
  (new ClientController())->delete($req, $res);
});

// client post
$app->post('/pw2/admin/client/store', function ($req, $res) {
  (new ClientController())->store($req, $res);
});
$app->post('/pw2/admin/client/update/:id', function ($req, $res) {
  (new ClientController())->update($req, $res);
});
