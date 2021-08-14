$(function () {
  if ($(window).width() > 800) {
    $("#aside").addClass("open");
  }
  $("#btn-aside").on("click", () => {
    $("#aside").toggleClass("open");
  });
  $("#btn-aside").on("click", () => {
    $("#aside").removeClass("open");
  });
});
