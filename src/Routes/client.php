<?php

namespace App\Routes;

use App\Controllers\ClientController;

// clients
$app->get("/pw2/client", function ($req, $res) {
    (new ClientController())->index($req, $res);
});
