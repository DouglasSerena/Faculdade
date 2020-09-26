<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

  <link rel="stylesheet" href="/pw2/public/assets/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
  <script src="/pw2/public/assets/js/bootstrap.min.js"></script>
  <script src="/pw2/public/assets/js/message.js"></script>

  <link rel="stylesheet" href="/pw2/public/assets/css/main.css">

  <title>Document</title>
</head>

<body>
  <header>
    <nav>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/pw2">StoreDSS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="nav">
          <ul class="navbar-nav">
            <li class="nav-item action">
              <a class="nav-link" href="/pw2/admin">home</a>
            </li>
            <li class="nav-item action">
              <a class="nav-link <?= strstr($url, "/pw2/admin/client/store") ? "active" : ""; ?>" href="/pw2/admin/client/store">Adicionar Cliente</a>
            </li>
            <li class="nav-item action">
              <a class="nav-link <?= strstr($url, "/pw2/admin/client") ? "active" : ""; ?>" href="/pw2/admin/client">List Clients</a>
            </li>
            <li class="nav-item action">
              <a class="nav-link <?= strstr($url, "/pw2/admin/product/create") ? "active" : ""; ?>" href="/pw2/admin/product/create">add produto</a>
            </li>
            <li class="nav-item action">
              <a class="nav-link" href="/pw2/admin/logout"><i class="ri-logout-circle-line"></i>Logout</a>
            </li>
          </ul>
        </div>
      </nav>
    </nav>
  </header>

  <main>
    <?php require "$content"; ?>
  </main>

  <?php if (isset($query['message'])) : ?>
    <script>
      message('<?= $query['message'] . "','" . $query['type'] ?>');
    </script>
  <?php endif; ?>
</body>

</html>