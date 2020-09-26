<?php

namespace App\Routes;

use App\Controllers\ProductController;

// products
$app->get("/pw2/products", function ($req, $res) {
    (new ProductController())->index($req, $res);
});
