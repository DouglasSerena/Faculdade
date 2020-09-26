<?php

namespace App\Admin\Routes;

use App\Admin\Controllers\ClientController;

// clients
$app->get("/ULBRA_FACUDADE/admin/client", function ($req, $res) {
  (new ClientController())->index($req, $res);
});
$app->get('/ULBRA_FACUDADE/admin/client/store', function ($req, $res) {
  $res->render('client/store');
}); // render file
$app->get('/ULBRA_FACUDADE/admin/client/update/:id', function ($req, $res) {
  $res->render('client/update');
}); // render file
$app->get("/ULBRA_FACUDADE/admin/client/:id", function ($req, $res) {
  (new ClientController())->getById($req, $res);
});
$app->get('/ULBRA_FACUDADE/admin/client/delete/:id', function ($req, $res) {
  (new ClientController())->delete($req, $res);
});

// client post
$app->post('/ULBRA_FACUDADE/admin/client/store', function ($req, $res) {
  (new ClientController())->store($req, $res);
});
$app->post('/ULBRA_FACUDADE/admin/client/update/:id', function ($req, $res) {
  (new ClientController())->update($req, $res);
});
