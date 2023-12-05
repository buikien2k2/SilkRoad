let lcs_btn_i = document.querySelector(".lcs-btn_i");
let post_icon_btn_i = document.querySelector("#post-icon-btn_i");
let post_icon_text_i = document.querySelector("#post-icon-text_i");

lcs_btn_i.addEventListener("click", function () {
  post_icon_btn_i.classList.toggle("fas");
  post_icon_text_i.innerHTML = "Like";
  post_icon_text_i.classList.toggle("like-controle");
  post_icon_btn_i.classList.toggle("like-controle");
});

let edit_profile_btn = document.getElementById("edit-profile-btn");
edit_profile_btn.addEventListener("click", function () {
  window.location.href = "/SilkRoad/editProfile.html";
});

let edit_bio_btn = document.getElementById("edit-bio-btn");
edit_bio_btn.addEventListener("click", function () {
  window.location.href = "/SilkRoad/editProfileDetail.html";
});

let changeCoverImageInput = document.getElementById("changeCoverImageInput");
let coverImageElement = document.getElementById("coverImageElement");
function handleChangeCoverImageButtonClick() {
  changeCoverImageInput.click();
}
changeCoverImageInput.addEventListener("change", function () {
  if (changeCoverImageInput.files.length > 0) {
    const file = changeCoverImageInput.files[0];
    const objectURL = URL.createObjectURL(file);

    coverImageElement.src = objectURL;
  }
});

let changeAvatarImageInput = document.getElementById("changeAvatarImageInput");
let avatarImageElement = document.getElementById("Self_Profile_images");
function handleChangeAvatarImageButtonClick() {
  changeAvatarImageInput.click();
}
changeAvatarImageInput.addEventListener("change", function () {
  if (changeAvatarImageInput.files.length > 0) {
    const file = changeAvatarImageInput.files[0];
    const objectURL = URL.createObjectURL(file);

    avatarImageElement.src = objectURL;
  }
});

