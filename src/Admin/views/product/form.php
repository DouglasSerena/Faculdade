<div class="container">
  <h1 class="mt-3 text-center">Adicionar um produto</h1>
  <form action="/ULBRA_FACUDADE/admin/product/create" method="POST" class="shadow mt-3 p-4">
    <div class="row">
      <div class="col-md-9">
        <div class="form-group">
          <label for="name">Nome</label>
          <input data-type="name" required class="form-control" type="text" id="name" name="name" placeholder="Nome do produto">
          <div class="invalid-feedback"></div>
        </div>
        <div class="form-group">
          <label for="price">Valor</label>
          <input data-type="price" required class="form-control" type="text" id="price" name="price" placeholder="Valor">
          <div class="invalid-feedback"></div>
        </div>
        <div class="form-group">
          <label for="description">Descrição</label>
          <textarea data-type="description" required maxlength="255" class="form-control" name="description" id="description" rows="3" placeholder="Breve descrição do produto"></textarea>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="form-group">
          <label for="category">Categoria</label>
          <select data-type="category" class="custom-select" name="category" id="category">
            <option value="1" selected>Celular</option>
            <option value="2">Notebook</option>
            <option value="3">Monitor</option>
            <option value="4">Teclado</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
        <div class="form-group">
          <input data-type="spotlight" type="checkbox" name="spotlight" id="spotlight">
          <label for="spotlight">Destaque</label>
        </div>
      </div>
    </div>
    <input class="btn btn-primary" name="signup" type="submit" value="Adicionar">
  </form>
</div>
<script src="https://github.com/codermarcos/simple-mask-money/releases/download/v3.0.0/simple-mask-money.js"></script>
<script src="/ULBRA_FACUDADE/public/assets/js/services/app.js" type="module"></script>
<script>
  const price = document.querySelector('#price');
  const spotlight = document.querySelector('#spotlight');
  const form = document.querySelector('form');

  form.addEventListener('submit', (e) => {
    price.value = price.formatToNumber();
    spotlight.value = spotlight.checked ? '1' : '0'
  })
</script>