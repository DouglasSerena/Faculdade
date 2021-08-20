$(function () {
  $("#contact-body").append(
    $(`
      <tr>
        <td>${this.data.name}</td>
        <td>${this.data.email}</td>
        <td>${this.data.subject}</td>
      </tr>
    `).html()
  );
});
