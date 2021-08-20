$(function () {
  if (!this.$data) {
    return this.$redirect("contact");
  }

  $("#contact-body").html(`
    <tr>
      <td>${this.$data.name}</td>
      <td>${this.$data.email}</td>
      <td>${this.$data.tel}</td>
      <td>${this.$data.subject}</td>
    </tr>
  `);
});
