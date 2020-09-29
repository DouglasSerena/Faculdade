<div class="container">
  <div class="col-12 m-0 mt-2 row justify-content-between align-items-center">
    <h1 class="col-md-8">Produtos</h1>
    <input class="col-md-4 form-control" type="text" placeholder="Search...">
  </div>
  <div class="row justify-content-center align-items-center">
    <?php foreach ($datas as $product) : ?>
      <div class="col-sm-6 col-md-4 col-xl-3 p-1 d-flex justify-content-center h-100">
        <div class="card" style="width: 18rem;">
          <img src="//via.placeholder.com/500x500" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title"><?= $product['name'] ?></h5>
            <p class="card-text" style="height: 50px;overflow-y: hidden;"><?= $product['description'] ?></p>
            <div class="d-flex justify-content-between align-items-center">
              <a href="#" class="btn btn-success">Comprar</a>
              <h5 id="price" class="m-0 font-weight-bold">R$ <?= $product['price'] ?></h5>
            </div>
          </div>
        </div>
      </div>
    <?php endforeach ?>
  </div>
</div>