<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    <link rel="stylesheet" href="/ULBRA_FACUDADE/public/assets/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="/ULBRA_FACUDADE/public/assets/js/bootstrap.min.js"></script>
    <script src="/ULBRA_FACUDADE/public/assets/js/message.js"></script>

    <link rel="stylesheet" href="/ULBRA_FACUDADE/public/assets/css/main.css">

    <title>Document</title>
</head>

<body>
    <header>
        <nav>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="/ULBRA_FACUDADE">StoreDSS</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="nav">
                    <ul class="navbar-nav">
                        <li class="nav-item action">
                            <a class="nav-link" href="/ULBRA_FACUDADE/products">Produtos</a>
                        </li>
                        <li class="nav-item action">
                            <a class="nav-link" href="/ULBRA_FACUDADE/client">Lista de Usuários</a>
                        </li>
                        <li class="nav-item action">
                            <a class="nav-link" href="/ULBRA_FACUDADE/about">Sobre</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </nav>
    </header>

    <main class="m-5">
        <?php require "$content"; ?>
    </main>

    <footer class="fixed-bottom text-center justify-content-center align-items-center bg-dark">
        <a class="alert-link" href="/ULBRA_FACUDADE/login">Admin</a>
    </footer>

    <?php if (isset($query['message'])) : ?>
        <script>
            message('<?= $query['message'] . "','" . $query['type'] ?>');
        </script>
    <?php endif; ?>
</body>

</html>