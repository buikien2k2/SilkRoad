const userId = document.getElementById("hiddenInputUserId").dataset.userid;
const userLoggedInId = document.getElementById("hiddenInputUserLoggedInId")
  .dataset.userloggedinid;

let lcs_btn_i = document.querySelector(".lcs-btn_i");
let post_icon_btn_i = document.querySelector("#post-icon-btn_i");
let post_icon_text_i = document.querySelector("#post-icon-text_i");

lcs_btn_i.addEventListener("click", function () {
  post_icon_btn_i.classList.toggle("fas");
  post_icon_text_i.innerHTML = "Like";
  post_icon_text_i.classList.toggle("like-controle");
  post_icon_btn_i.classList.toggle("like-controle");
});

let lcs_btn_v = document.querySelector(".lcs-btn_v");
let post_icon_btn_v = document.querySelector("#post-icon-btn_v");
let post_icon_text_v = document.querySelector("#post-icon-text_v");

lcs_btn_v.addEventListener("click", function () {
  post_icon_btn_v.classList.toggle("fas");
  post_icon_text_v.innerHTML = "Like";
  post_icon_text_v.classList.toggle("like-controle");
  post_icon_btn_v.classList.toggle("like-controle");
});

let lcs_btn_t = document.querySelector(".lcs-btn_t");
let post_icon_btn_t = document.querySelector("#post-icon-btn_t");
let post_icon_text_t = document.querySelector("#post-icon-text_t");

lcs_btn_t.addEventListener("click", function () {
  post_icon_btn_t.classList.toggle("fas");
  post_icon_text_t.innerHTML = "Like";
  post_icon_text_t.classList.toggle("like-controle");
  post_icon_btn_t.classList.toggle("like-controle");
});

let lcs_btn_bt = document.querySelector(".lcs-btn_bt");
let post_icon_btn_bt = document.querySelector("#post-icon-btn_bt");
let post_icon_text_bt = document.querySelector("#post-icon-text_bt");

lcs_btn_bt.addEventListener("click", function () {
  post_icon_btn_bt.classList.toggle("fas");
  post_icon_text_bt.innerHTML = "Like";
  post_icon_text_bt.classList.toggle("like-controle");
  post_icon_btn_bt.classList.toggle("like-controle");
});

let lcs_btn_2i = document.querySelector(".lcs-btn_2i");
let post_icon_btn_2i = document.querySelector("#post-icon-btn_2i");
let post_icon_text_2i = document.querySelector("#post-icon-text_2i");

lcs_btn_2i.addEventListener("click", function () {
  post_icon_btn_2i.classList.toggle("fas");
  post_icon_text_2i.innerHTML = "Like";
  post_icon_text_2i.classList.toggle("like-controle");
  post_icon_btn_2i.classList.toggle("like-controle");
});

let lcs_btn_3i = document.querySelector(".lcs-btn_3i");
let post_icon_btn_3i = document.querySelector("#post-icon-btn_3i");
let post_icon_text_3i = document.querySelector("#post-icon-text_3i");

lcs_btn_3i.addEventListener("click", function () {
  post_icon_btn_3i.classList.toggle("fas");
  post_icon_text_3i.innerHTML = "Like";
  post_icon_text_3i.classList.toggle("like-controle");
  post_icon_btn_3i.classList.toggle("like-controle");
});

let lcs_btn_4i = document.querySelector(".lcs-btn_4i");
let post_icon_btn_4i = document.querySelector("#post-icon-btn_4i");
let post_icon_text_4i = document.querySelector("#post-icon-text_4i");

lcs_btn_4i.addEventListener("click", function () {
  post_icon_btn_4i.classList.toggle("fas");
  post_icon_text_4i.innerHTML = "Like";
  post_icon_text_4i.classList.toggle("like-controle");
  post_icon_btn_4i.classList.toggle("like-controle");
});

let lcs_btn_plus_i = document.querySelector(".lcs-btn_plus_i");
let post_icon_btn_plus_i = document.querySelector("#post-icon-btn_plus_i");
let post_icon_text_plus_i = document.querySelector("#post-icon-text_plus_i");

lcs_btn_plus_i.addEventListener("click", function () {
  post_icon_btn_plus_i.classList.toggle("fas");
  post_icon_text_plus_i.innerHTML = "Like";
  post_icon_text_plus_i.classList.toggle("like-controle");
  post_icon_btn_plus_i.classList.toggle("like-controle");
});
//  /////////////////////////////////////////////////////////////////////
let select_audience = document.querySelector(".popop-background");
let popop_background = document.querySelector(".Select-audience");
let public_btn_i = document.getElementById("public-btn-i");

public_btn_i.addEventListener("click", function () {
  popop_background.classList.toggle("dis_block");
  select_audience.classList.toggle("dis_block");
});

let popup_close_btn = document.getElementById("popup-close-btn");

popup_close_btn.addEventListener("click", function () {
  select_audience.classList.remove("dis_block");
  popop_background.classList.remove("dis_block");
});

select_audience.addEventListener("click", function () {
  select_audience.classList.remove("dis_block");
  popop_background.classList.remove("dis_block");
});
let public_btn = document.getElementById("public-btn");
let friends_btn = document.getElementById("friends-btn");
let lock_btn = document.getElementById("lock-btn");

let public_li_icon = document.getElementById("public-li-icon");
let friends_li_icon = document.getElementById("friends-li-icon");
let lock_li_icon = document.getElementById("lock-li-icon");

public_btn.addEventListener("click", function () {
  public_btn.classList.add("activ-li-div");
  friends_btn.classList.remove("activ-li-div");

  public_li_icon.classList.add("activ-li-icon");
  public_li_icon.classList.add("fa-dot-circle");

  lock_li_icon.classList.remove("activ-li-icon");
  public_btn_i.classList.remove("fa-lock");
  lock_li_icon.classList.add("fa-circle");
  lock_btn.classList.remove("activ-li-div");

  friends_li_icon.classList.remove("activ-li-icon");
  friends_li_icon.style.color = "#707070";
  friends_li_icon.classList.add("fa-circle");
  friends_li_icon.classList.remove("fa-dot-circle");

  public_btn_i.classList.add("fa-globe-europe");
  public_btn_i.classList.remove("fa-user-friends");

  select_audience.classList.remove("dis_block");
  popop_background.classList.remove("dis_block");
});
friends_btn.addEventListener("click", function () {
  public_btn.classList.remove("activ-li-div");
  friends_btn.classList.add("activ-li-div");

  public_li_icon.classList.remove("activ-li-icon");
  public_li_icon.classList.remove("fa-dot-circle");

  friends_li_icon.classList.add("activ-li-icon");
  friends_li_icon.classList.remove("fa-circle");
  friends_li_icon.classList.add("fa-dot-circle");

  lock_li_icon.classList.remove("activ-li-icon");
  public_btn_i.classList.remove("fa-lock");
  lock_li_icon.classList.add("fa-circle");
  lock_btn.classList.remove("activ-li-div");
  lock_li_icon.classList.remove("fa-dot-circle");

  public_btn_i.classList.remove("fa-globe-europe");
  public_btn_i.classList.add("fa-user-friends");

  select_audience.classList.remove("dis_block");
  popop_background.classList.remove("dis_block");
});

lock_btn.addEventListener("click", function () {
  public_btn.classList.remove("activ-li-div");
  friends_btn.classList.remove("activ-li-div");

  public_li_icon.classList.remove("activ-li-icon");
  public_li_icon.classList.remove("fa-dot-circle");

  friends_li_icon.classList.remove("activ-li-icon");
  friends_li_icon.style.color = "#707070";
  friends_li_icon.classList.add("fa-circle");
  friends_li_icon.classList.remove("fa-dot-circle");

  lock_li_icon.classList.remove("fa-circle");
  lock_li_icon.classList.add("fa-dot-circle");
  lock_li_icon.classList.add("activ-li-icon");
  lock_btn.classList.add("activ-li-div");

  public_btn_i.classList.remove("fa-globe-europe");
  public_btn_i.classList.remove("fa-user-friends");
  public_btn_i.classList.add("fa-lock");

  select_audience.classList.remove("dis_block");
  popop_background.classList.remove("dis_block");
});
/////////////////////////////////////////////////////////////////
// let edit_profile_btn = document.getElementById("edit-profile-btn");
// edit_profile_btn.addEventListener("click", function () {
//   window.location.href = "/editProfile.html";
// });

let edit_bio_btn = document.getElementById("edit-bio-btn");
edit_bio_btn.addEventListener("click", function () {
  window.location.href = "/editProfileDetail.html";
});
///////////////////////////////////////////////////////////////////////////
let changeCoverImageInput = document.getElementById("changeCoverImageInput");
let coverImageElement = document.getElementById("coverImageElement");
let coverImage = document.getElementById("cover-image-section");
function handleChangeCoverImageButtonClick() {
  changeCoverImageInput.click();
}
changeCoverImageInput.addEventListener("change", function () {
  if (changeCoverImageInput.files.length > 0) {
    const file = changeCoverImageInput.files[0];
    const objectURL = URL.createObjectURL(file);
    coverImageElement.src = objectURL;
    coverImageElement.style.display = "block";
    coverImage.classList.add("activ-show");

    var formData = new FormData();
    formData.append("file", file);

    fetch(`/profile/uploadCoverImg/${userId}`, {
      method: "POST",
      body: formData,
    });
  }
});
////////////////////////////////////////////////////////////////
let changeAvatarImageInput = document.getElementById("changeAvatarImageInput");
let avatarImageElement = document.getElementById("Profile_Avatar");
function handleChangeAvatarImageButtonClick() {
  changeAvatarImageInput.click();
}
changeAvatarImageInput.addEventListener("change", function () {
  if (changeAvatarImageInput.files.length > 0) {
    const file = changeAvatarImageInput.files[0];
    const objectURL = URL.createObjectURL(file);

    avatarImageElement.src = objectURL;

    var formData = new FormData();
    formData.append("file", file);

    fetch(`/profile/uploadAvatarImg/${userId}`, {
      method: "POST",
      body: formData,
    });
  }
});
///////////////////////////////////////////////////////////////
let vidio_tge = document.querySelectorAll("#vidio-tge");
let video_update = document.querySelectorAll("#video-update");

for (let i = 0; i < vidio_tge.length; i++) {
  vidio_tge[i].src = "/video/FoolForYou.mp4";
  video_update[i].src = "/video/FoolForYou.mp4";
}
///////////////////////////////////////////////////////////////////
const btnPost = document.getElementById("post-nav");
const btnAbout = document.getElementById("about-nav");
const btnFriends = document.getElementById("friends-nav");
const btnPhoto = document.getElementById("photo-nav");
const btnVideo = document.getElementById("video-nav");
const btnLikes = document.getElementById("likes-nav");
const btnMore = document.getElementById("more-nav");
const tab1 = document.getElementById("tab-1");
const tab2 = document.getElementById("tab-2");
const tab3 = document.getElementById("tab-3");
const tab4 = document.getElementById("tab-4");
const tab5 = document.getElementById("tab-5");
const tab6 = document.getElementById("tab-6");
const tab7 = document.getElementById("tab-7");

function navClick(btnPost, btnFriends, tab1, tab3) {
  tab1.style.display = "block";
  btnPost.addEventListener("click", () => {
    if (!btnPost.classList.contains("activ-navbar")) {
      btnPost.classList.add("activ-navbar");
      btnFriends.classList.remove("activ-navbar");
      tab1.style.display = "block";
      tab3.style.display = "none";
    }
  });

  btnFriends.addEventListener("click", () => {
    if (!btnFriends.classList.contains("activ-navbar")) {
      btnFriends.classList.add("activ-navbar");
      btnPost.classList.remove("activ-navbar");
      tab3.style.display = "block";
      tab1.style.display = "none";
    }
  });
}

navClick(btnPost, btnFriends, tab1, tab3);
////////////////////////////////////////////////////////////////////////////////////////////////
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
