$(function () {
  $(document).scroll(function () {
    var $nav = $(".navbar.navbar-inverse.navbar-fixed-top");
    $nav.toggleClass('scrolled', $(this).scrollTop() > $nav.height());
  });
});