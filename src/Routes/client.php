<?php

namespace App\Routes;

use App\Controllers\ClientController;

// clients
$app->get("/ULBRA_FACUDADE/client", function ($req, $res) {
    (new ClientController())->index($req, $res);
});
