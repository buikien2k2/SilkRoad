document.getElementById("hahaha").addEventListener("click", function (event) {
    document.getElementById("overlay").style.display = "block";
    console.log("click")
    event.preventDefault(); // Sử dụng event.preventDefault()
    return false;
});
// Thêm sự kiện click cho hình mờ (overlay)
document.getElementById("overlay").addEventListener("click", function (e) {
    if (e.target === document.getElementById("overlay")) {
        document.getElementById("overlay").style.display = "none";
    }
});
const container = document.querySelector(".container"),
    privacy = container.querySelector(".post .privacy"),
    arrowBack = container.querySelector(".audience .arrow-back");

privacy.addEventListener("click", () => {
    container.classList.add("active");
    arrowBack.style.display = "block";
    privacy.style.display = "none";
});

arrowBack.addEventListener("click", () => {
    container.classList.remove("active");
    privacy.style.display = "block";
    arrowBack.style.display = "none";
});