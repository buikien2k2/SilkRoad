document.getElementById("create-btn").addEventListener("click", function(event) {
    document.getElementById("overlay").style.display = "block";
    console.log("click")
    event.preventDefault(); // Sử dụng event.preventDefault()
    return false;
  });
  
  document.getElementById("closeButton").addEventListener("click", function() {
    document.getElementById("overlay").style.display = "none";
  });
  
  // Thêm sự kiện click cho hình mờ (overlay)
  document.getElementById("overlay").addEventListener("click", function(e) {
    if (e.target === document.getElementById("overlay")) {
        document.getElementById("overlay").style.display = "none";
    }
  });

