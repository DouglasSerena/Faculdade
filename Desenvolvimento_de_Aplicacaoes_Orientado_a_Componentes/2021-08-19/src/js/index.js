window.__dirname__ = "/src";

$(function () {
  if ($(window).width() > 800) {
    $("#aside").addClass("open");
  }
  $("#btn-aside").on("click", () => {
    $("#aside").toggleClass("open");
  });
  this.render("home");

  for (let link of $("#aside [data-render]")) {
    $(link).on("click", () => {
      activeLink(link);
      this.render($(link).data().render);
    });
  }
});

function activeLink(ref) {
  for (let link of $("#aside [data-render]")) {
    $(link).removeClass("active");
  }
  $(ref).addClass("active");
}

document.render = function (render, data) {
  this.data = data;
  switch (render) {
    case "home":
      $("#root").load(`${__dirname__}/views/home`);
      break;
    case "about":
      $("#root").load(`${__dirname__}/views/about`);
      break;
    case "contact":
      $("#root").load(`${__dirname__}/views/contact`);
      break;
    case "contact-info":
      $("#root").load(`${__dirname__}/views/contact/info`);
      break;
  }
};
