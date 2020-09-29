<?php

namespace App\Routes;

use App\Admin\Controllers\ProductController;

$app->get('/ULBRA_FACUDADE/admin/product/create', function ($req, $res) {
  $res->render('product/form');
});

// product post
$app->post('/ULBRA_FACUDADE/admin/product/create', function ($req, $res) {
  (new ProductController())->create($req, $res);
});
