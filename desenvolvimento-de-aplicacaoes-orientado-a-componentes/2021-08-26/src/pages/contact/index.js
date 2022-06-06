$(function () {
  const debounce = utils.debounce(5000);

  $("#loading").hide();
  $("#alert-error").hide();

  utils.masked("tel").bind($("#tel").get(0));
  utils.masked("cep").bind($("#cep").get(0));

  $validator("#name", { required: "Informe seu nome." });
  $validator("#email", {
    required: "Informe seu email.",
    email: "Informe um email valido.",
  });
  $validator("#tel", {
    required: "Informe seu telefone.",
    minlength: "Informe um número valido.",
  });
  $validator("#cep", {
    required: "Informe seu cep.",
    minlength: "Informe um número valido.",
  });

  $("#contact-form").on("submit", async (event) => {
    event.preventDefault();
    $("#loading").show();

    const { email, name, tel, cep, subject } = event.target;
    const [data] = await utils.handleTry(findCep($(cep).val()));

    $("#loading").hide();
    if (data.localidade) {
      this.$redirect("contact/info", {
        email: $(email).val(),
        name: $(name).val(),
        tel: $(tel).val(),
        cep: $(cep).val(),
        localidade: data.localidade,
        subject: $(subject).val(),
      });
    } else {
      $("#alert-error").text("Não foi possível encontrar o cep");
      $("#alert-error").show();
      debounce.run(() => {
        $("#alert-error").hide();
      });
    }
  });
});

function searchCep(cep, callback) {
  $.get(`https://viacep.com.br/ws/${cep}/json`).done(callback)
}
