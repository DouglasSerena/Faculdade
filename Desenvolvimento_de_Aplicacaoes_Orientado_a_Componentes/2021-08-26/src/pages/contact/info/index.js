$(function () {
  if (!this.$data) {
    return this.$redirect("contact");
  }

  $("#name").text(this.$data.name);
  $("#email").text(this.$data.email);
  $("#tel").text(this.$data.tel);
  $("#cep").text(this.$data.cep);
  $("#localidade").text(this.$data.localidade);
  $("#subject").text(this.$data.subject);
});
