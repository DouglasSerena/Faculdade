<?php

namespace App;

use App\ControlRoute\App;

require "vendor/autoload.php";

$app = new App();

require './src/Routes/page.php';
require './src/Routes/client.php';
require './src/Routes/product.php';

require './src/Admin/index.php';

$app->get('**', function ($req, $res) {
    $res->render('error/error');
});
