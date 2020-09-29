<form class="container shadow-lg p-3 mt-5" style="max-width: 400px;" action="/ULBRA_FACUDADE/login" method="post">
    <h2 class="text-center">Logar</h2>
    <div class="form-group">
        <label for="user">Usuário</label>
        <input data-type="name" required type="text" maxlength="100" name="user" id="user" class="form-control" placeholder="Usuário">
        <div class="invalid-feedback"></div>
    </div>
    <div class="form-group">
        <label for="password">Senha</label>
        <input data-type="password" required type="password" id="password" name="password" class="form-control" placeholder="Senha">
        <div class="invalid-feedback"></div>
    </div>
    <input type="submit" class="btn btn-primary w-100" value="Logar">
</form>
<script src="/ULBRA_FACUDADE/public/assets/js/services/app.js" type="module"></script>