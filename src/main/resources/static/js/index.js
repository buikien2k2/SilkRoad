$(document).ready(function () {
  //story slider
  $(".slider").owlCarousel({
    loop: true,
    margin: 10,
    nav: false,
    dots: false,
    autoplay: true,
    autoplayTimeout: 3000,
    smartSpeed: 1000,
    autoplayHoverPause: true,
    responsive: {
      0: {
        items: 1,
      },
      600: {
        items: 1,
      },
      1000: {
        items: 5,
      },
    },
  });

  var owl = $(".slider");
  owl.owlCarousel();
  // Go to the next item
  $(".nxtBtn").click(function () {
    owl.trigger("next.owl.carousel");
  });

  $(".rooms").owlCarousel({
    loop: true,
    margin: 5,
    nav: false,
    dots: false,
    autoplay: true,
    autoplayTimeout: 3000,
    smartSpeed: 1000,
    autoplayHoverPause: true,
    responsive: {
      0: {
        items: 1,
      },
      600: {
        items: 1,
      },
      1000: {
        items: 10,
      },
    },
  });

  $(".people").owlCarousel({
    loop: true,
    margin: 5,
    nav: false,
    dots: false,
    autoplay: true,
    autoplayTimeout: 3000,
    smartSpeed: 1000,
    autoplayHoverPause: true,
    responsive: {
      0: {
        items: 1,
      },
      600: {
        items: 1,
      },
      1000: {
        items: 3.5,
      },
    },
  });
});
// //////////////////////////////////////////////////////////////////////////////////
document.getElementById("profile").addEventListener("click", function () {
  if (document.getElementById("dropdown-profile").style.display === "none") {
    document.getElementById("dropdown-profile").style.display = "block";
  } else {
    document.getElementById("dropdown-profile").style.display = "none";
  }
});
// //////////////////////////////////////////////////////////////////////////////////////////
comment_inputs = document.querySelectorAll(".input input");

function makeComment(text) {
  document
    .querySelector(".view-post")
    .querySelector(".comment-box").innerHTML += `
	<div class="comment-container">
		<div class="comment">
		<img src="img/avatar/hero.png" alt="" class="comment-img">
		<div class="comment-text">
			<div class="comment-header">
			<p><strong>Bùi Kiên</strong></p>
			</div>
			<p>${text}</p>
		</div>
		<div class="three-dot">
			<img src="svg/three_dot_gray.svg" class="three-dot-img" alt="">
		</div>
		</div>
		<div class="comment-lks">
		<p>
			<span>Like</span><span class="dot"> . </span>
			<span>Reply</span><span class="dot"> . </span>
			<span>Share</span><span class="dot"> . </span>
			<span>just now</span></p>
		</div>
	</div>
	`;
}

window.addEventListener("load", function () {
  comment_inputs.forEach((input) => {
    input.addEventListener("change", (e) => {
      makeComment(input.value);
      input.value = "";
    });
  });
});
////////////////////////////////////////////////////////////////////////
let prevScrollPos = window.pageYOffset;

window.onscroll = function () {
  let currentScrollPos = window.pageYOffset;
  prevScrollPos = currentScrollPos;
};
