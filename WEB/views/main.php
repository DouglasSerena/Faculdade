<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="public/css/remix/remixicon.css">
  <link rel="stylesheet" href="public/css/main.css">

  <title>PAGE | <?= $title ?></title>
</head>

<body id="container">
  <header id="header" class="bg-dark">
    <h1 class="text-white"><?= $title ?></h1>
    <button id="menu" onclick=""><i class="ri-menu-line"></i></button>
  </header>

  <aside id="aside" class="bg-secondary">
    <ul class="nav-bar">
      <li><a href="?control=main&action=index"><i class="ri-home-line"></i>Home</a></li>
      <li><a href="?control=product&action=index"><i class="ri-shopping-cart-2-line"></i>Products</a></li>
      <li><a href="?control=client&action=index"><i class="ri-user-line"></i>Client</a></li>
    </ul>
  </aside>
  <main id="main" class="bg-light">
    <?php require 'views/' . $view . '.php'; ?>
  </main>


  <footer id="footer" class="bg-dark">
    <a href="/ULBRA_FACUDADE/WEB/admin/?control=main&action=index">Area de administração</a>
  </footer>

  <script src="public/js/message.js"></script>
  <script>
    const menu = document.getElementById('menu');
    const aside = document.getElementById('aside');
    const main = document.getElementById('main');

    menu.onclick = () => {
      aside.classList.toggle('open');
      main.classList.toggle('open');
    }
    main.onclick = () => {
      if (main.classList.contains('open')) {
        aside.classList.remove('open');
        main.classList.remove('open');
      }
    }

    <?php if (isset($_GET['message'])) : ?>
      message(<?= "'{$_REQUEST['message']}', '{$_GET['type']}'" ?>);
    <?php endif; ?>
  </script>
</body>

</html>