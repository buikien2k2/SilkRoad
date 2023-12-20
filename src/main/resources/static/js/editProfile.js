const editProfileChooseImageButton = document.getElementById(
  "editProfileButtonChooseImage"
);

const editProfileInputFile = document.getElementById(
  "editProfileInputImageFile"
);

const editProfileDateOfBirth = document.getElementById(
  "editProfileDateOfBirth"
);

editProfileChooseImageButton.addEventListener("click", () => {
  editProfileInputFile.click();
});

editProfileDateOfBirth.addEventListener("change", (e) => {
  let date = e.target.value;
  editProfileDateOfBirth.innerText = date;
});

