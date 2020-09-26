<div class="container mt-3">
  <div class="row">
    <h1 class="col-12 text-center mb-4">Bem vindo <?= $session['logged']['user'] ?></h1>
    <a href="/pw2/admin/client/store" class="col-md-3 icons-admin-menu">
      <div class="shadow border">
        <p>
          Adicionar Clientes
        </p>
        <img src="public/assets/icons/user-plus-solid.svg" alt="listar clientes" />
      </div>
    </a>
    <a href="/pw2/admin/client" class="col-md-3 icons-admin-menu">
      <div class="shadow border">
        <p>
          Listar Clientes
        </p>
        <img src="public/assets/icons/list-alt-solid.svg" alt="listar clientes" />
      </div>
    </a>
    <a href="/pw2/admin/product/create" class="col-md-3  icons-admin-menu">
      <div class="shadow border">
        <p>
          Adicionar novo produto
        </p>
        <img src="public/assets/icons/cart-plus-solid.svg" alt="adicionar Produto" />
      </div>
    </a>
  </div>
</div>