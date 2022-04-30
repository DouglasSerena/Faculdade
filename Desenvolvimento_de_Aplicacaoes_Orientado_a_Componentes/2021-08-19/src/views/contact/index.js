$(function () {
  utils.masked("tel").bind($("#tel").get(0));

  $validator("#name", { required: "Informe seu nome." });
  $validator("#email", {
    required: "Informe seu email.",
    email: "Informe um email valido.",
  });
  $validator("#tel", {
    required: "Informe seu telefone.",
    minlength: "Informe um número valido.",
  });

  $("#contact-form").on("submit", (event) => {
    event.preventDefault();
    const { email, name, tel, subject } = event.target;

    this.$redirect("contact/info", {
      email: $(email).val(),
      name: $(name).val(),
      tel: $(tel).val(),
      subject: $(subject).val(),
    });
  });
});
