<?php

namespace App\Routes;

use App\Controllers\ProductController;

// products
$app->get("/ULBRA_FACUDADE/products", function ($req, $res) {
    (new ProductController())->index($req, $res);
});
