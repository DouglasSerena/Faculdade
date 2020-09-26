<div class="container">
  <h1 class="mt-3 text-center">Atualizar</h1>
  <form action="/ULBRA_FACUDADE/admin/client/update/<?= $params['id'] ?>" method="POST" class="shadow mt-3 p-4">
    <!-- personal data -->
    <div class="form-row form-group">
      <div class="col-md-3">
        <label for="name">Name</label>
        <input data-type="name" required pattern="[\w ]*" maxlength="50" type="text" id="name" name="name" class="form-control" placeholder="Nome">
        <div class="invalid-feedback"></div>
      </div>
      <div class="col-md-5">
        <label for="email">Email</label>
        <input data-type="email" required type="email" maxlength="100" name="email" id="email" class="form-control" placeholder="E-mail">
        <div class="invalid-feedback"></div>
      </div>
      <div class="col-md-4">
        <label for="phone">Telefone</label>
        <input type="hidden" name="ddd" id="ddd" />
        <input data-type="phone" required pattern="\d+" maxlength="9" minlength="9" type="text" name="phone" id="phone" class="form-control" placeholder="Telefone">
        <div class="invalid-feedback"></div>
      </div>
    </div>

    <!-- address -->
    <div class="form-row form-group">
      <div class="col-md-3">
        <label for="zip">Cep</label>
        <input data-type="zip" pattern="\d{5}-\d{3}" maxlength="9" required type="text" id="zip" class="form-control" placeholder="Cep">
        <div class="invalid-feedback"></div>
      </div>
      <div class="col-md-3">
        <label for="street">Rua - Número</label>
        <input data-type="street" required type="text" id="street" class="form-control" placeholder="R. exemplo, 1524">
        <div class="invalid-feedback"></div>
      </div>
      <div class="col-md-3">
        <label for="state">Estado</label>
        <select data-type="state" required id="state" id="state" class="custom-select">
          <option selected disabled hidden>Estado</option>
        </select>
        <div class="invalid-feedback"></div>
      </div>
      <div class="col-md-3">
        <label for="city">Cidade</label>
        <input data-type="city" required type="text" id="city" class="form-control" placeholder="Cidade">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    <input type="hidden" id="address" name="address">
    <input type="hidden" name="id" value="<?= $params['id'] ?>">
    <input class="btn btn-primary" name="update" type="submit" value="Atualizar">
    <a href="/ULBRA_FACUDADE/client" class="btn btn-danger">Voltar</a>
  </form>
</div>
<script src="/ULBRA_FACUDADE/public/assets/js/services/app.js" type="module"></script>
<script>
  const API_STATE = `https://servicodados.ibge.gov.br/api/v1/localidades/estados`;
  const state = document.querySelector('#state');

  fetch(API_STATE).then(res => res.json()).then(data => {
    data.forEach(stateJson =>
      state.innerHTML += `<option value="${stateJson.sigla}">${stateJson.nome}</option>`
    );
  });

  document.querySelector('form').addEventListener('submit', event => {
    address.value = `${street.value}. ${city.value}-${state.value} ${zip.value}`
  })
</script>