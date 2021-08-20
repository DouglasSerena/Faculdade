$(function () {
  $("#contact-form").on("submit", (event) => {
    event.preventDefault();
    const { email, name, subject } = event.target;
    this.render("contact-info", {
      email: $(email).val(),
      name: $(name).val(),
      subject: $(subject).val(),
    });
  });
});
