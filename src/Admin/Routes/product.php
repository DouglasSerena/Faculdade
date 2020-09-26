<?php

namespace App\Routes;

use App\Admin\Controllers\ProductController;

$app->get('/pw2/admin/product/create', function ($req, $res) {
  $res->render('product/form');
});

// product post
$app->post('/pw2/admin/product/create', function ($req, $res) {
  (new ProductController())->create($req, $res);
});
