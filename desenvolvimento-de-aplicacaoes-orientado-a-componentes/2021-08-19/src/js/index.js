// CONSTANTES
window.path_views = "/src/views";

// ROTEAMENTO
function startRouter() {
  if (location.pathname.endsWith("index.html")) {
    history.replaceState({}, "", location.pathname.replace("index.html", ""));
  }
  render($(location).prop("hash").substring(2) || "home");

  function render(page) {
    $("#root").load(`${path_views}/${page}`);
    $(location).prop("hash", `#/${page}`);

    $("#aside a.active").removeClass("active");
    $(`#aside a[href="#/${page}"]`).addClass("active");
    if ($(window).width() <= 800) {
      $("#aside").removeClass("open");
    }
  }

  document.$redirect = function (page, data) {
    this.$data = data;
    this.location.hash = `#/${page}`;
  };

  $(window).on("hashchange", () => {
    render($(location).prop("hash").substring(2));
  });
}

// INICIAR
$(function () {
  if ($(window).width() > 800) {
    $("#aside").addClass("open");
  }
  $("#btn-aside").on("click", () => {
    $("#aside").toggleClass("open");
  });
  $("#overlay").on("click", () => {
    $("#aside").removeClass("open");
  });

  startRouter();
});

$.get("https://api.github.com/users/DouglasSerena").done((res) =>
  console.log(res)
);
