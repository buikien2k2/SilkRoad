function renderHeaderAndPost() {
  const header = `
    <nav>
        <!--logo and search-->
        <div class="left-side">
            <div class="logo">
                <a href="/">
                    <img src="/img/avatar/SilkRoad.jpg" alt="" >
                </a>
            
            </div>

            <div class="search">
                <input type="text" placeholder="Search SilkRoad" name="" id="">
            </div>
        </div>

        <!--tab icons-->
        <div class="tabs">
            <div class="tab-icon">
                <div class="icon">
                    <img src="/img/icons/home.svg" alt="">
                </div>
            </div>

            <div class="tab-icon">
                <div class="icon has-notification">
                    <img src="/img/icons/flag.svg" alt="">
                </div>
            </div>

            <div class="tab-icon">
                <div class="icon">
                    <img src="/img/icons/tv.svg" alt="">
                </div>
            </div>

            <div class="tab-icon">
                <div class="icon">
                    <img src="/img/icons/users.svg" alt="">
                </div>
            </div>


            <div class="tab-icon">
                <div class="icon has-notification">
                    <img src="/img/icons/calendar.svg" alt="">
                </div>
            </div>
        </div>

        <!--right side-->
        <div class="right-side">
            
            <!--icons-->
            <div class="user-icons">
                <div class="icon">
                    <img src="/img/icons/plus.svg" alt="">
                </div>

                <div class="icon has-notification">
                    <img src="/img/icons/messenger.svg" alt="">
                </div>

                <div class="icon">
                    <img src="/img/icons/bell.svg" alt="">
                </div>

                <div class="icon">
                    <img src="/img/icons/arrow.svg" alt="">
                </div>
            </div>
            <div class="user" id="profile-user">
                <div class="profile" id="profile">
                    <img src="/img/avatar/hero.png" alt="">
                </div>
                <div class="dropdown-profile" id="dropdown-profile">
                    <ul>
                        <li class="profile-drop" id="profile-setting">
                            <div class="profile" >
                                <img src="/img/avatar/hero.png" alt="">
                            </div>
                            <h4>Bùi Kiên</h4>
                        </li>
                        <li> 
                            <img src="/img/icons/gear-solid.svg" alt="">
                            <a href="">Cài đặt quyền riêng tư</a>
                        </li>
                        <li>
                            <img src="/img/icons/question-solid.svg" alt="">
                            <a href="">Trợ giúp & Hỗ trợ</a>
                        </li>
                        <li>
                            <img src="/img/icons/moon-solid.svg" alt="">
                            <a href="">Màn hình & trợ năng</a>
                        </li>
                        <li>
                            <img src="/img/icons/circle-exclamation-solid.svg" alt="">
                            <a href="">Đóng góp ý kiến</a>
                        </li>
                        <li>
                            <img src="/img/icons/right-from-bracket-solid.svg" alt="">
                            <a href="/logout">Đăng xuất</a>
                        </li>
                    </ul>
                </div>
                
                <!-- <h4>Bùi Kiên</h4> -->
            </div>
        </div>
    </nav>
    <div class="nav-site-profile" id="nav-site-profile" style="display: none;">
        <div class="nav-site-scroll">
            <div class="owner-profile">
                <div class="profile" >
                    <img src="/img/avatar/hero.png" alt="">
                </div>
                <h4>Bùi Kiên</h4>
            </div>
            <div class="nav-btn">
                <i class="fas fa-ellipsis-h"></i>
            </div>
        </div>
    </div>`;
  const newPost = `<div class="overlay1" id="overlay">
    <div class="container">
        <div class="form-container">
            <div class="cover" id="wrapper">
                <section class="post">
                    <span class="close" id="closeButton">&times;</span>
                    <header>Create Post</header>
                    <form action="#">
                        <div class="content">
                            <img src="/img/avatar/hero.png" alt="logo" />
                            <div class="details">
                                <p>Bùi Kiên</p>
                                <div class="privacy">
                                    <i class="fas fa-user-friends"></i>
                                    <span>Friends</span>
                                    <i class="fas fa-caret-down"></i>
                                </div>
                            </div>
                        </div>

                        <textarea placeholder="What's on your mind, Bùi Kiên?" spellcheck="false"></textarea>
                        <div class="theme-emoji">
                            <img src="/img/icons2/theme.svg" alt="theme" />
                            <img src="/img/icons2/smile.svg" alt="smile" />
                        </div>
                        <div class="options">
                            <p>Add to Your Post</p>
                            <ul class="list">
                                <li><img src="/img/icons2/gallery.svg" alt="gallery" /></li>
                                <li><img src="/img/icons2/tag.svg" alt="gallery" /></li>
                                <li><img src="/img/icons2/emoji.svg" alt="gallery" /></li>
                                <li><img src="/img/icons2/mic.svg" alt="gallery" /></li>
                                <li><img src="/img/icons2/more.svg" alt="gallery" /></li>
                            </ul>
                        </div>
                        <button>Post</button>
                    </form>
                </section>
                <section class="audience">
                    <header>
                        <div class="arrow-back"><i class="fas fa-arrow-left"></i></div>
                        <p>Select Audience</p>
                    </header>
                    <div class="content">
                        <p>Who can see your post?</p>
                        <span>Your post will show up in News Feed, on your profile and in search results.</span>
                    </div>
                    <ul class="list">
                        <li>
                            <div class="column">
                                <div class="icon"><i class="fas fa-globe-asia"></i></div>
                                <div class="details">
                                    <p>Public</p>
                                    <span>Anyone on or off SilkRoad</span>
                                </div>
                            </div>
                            <div class="radio"></div>
                        </li>
                        <li class="show">
                            <div class="column">
                                <div class="icon"><i class="fas fa-user-friends"></i></div>
                                <div class="details">
                                    <p>Friends</p>
                                    <span>Your friends on SilkRoad</span>
                                </div>
                            </div>
                            <div class="radio"></div>
                        </li>
                        <li>
                            <div class="column">
                                <div class="icon"><i class="fas fa-user"></i></div>
                                <div class="details">
                                    <p>Specific</p>
                                    <span>Only show to some friends</span>
                                </div>
                            </div>
                            <div class="radio"></div>
                        </li>
                        <li>
                            <div class="column">
                                <div class="icon"><i class="fas fa-lock"></i></div>
                                <div class="details">
                                    <p>Only me</p>
                                    <span>Only you can see your post</span>
                                </div>
                            </div>
                            <div class="radio"></div>
                        </li>
                        <li>
                            <div class="column">
                                <div class="icon"><i class="fas fa-cog"></i></div>
                                <div class="details">
                                    <p>Custom</p>
                                    <span>Include and exclude friends</span>
                                </div>
                            </div>
                            <div class="radio"></div>
                        </li>
                    </ul>
                </section>
            </div>
        </div>

    </div>
</div>
`;
  document.getElementById("header").innerHTML = header;
  document.getElementById("make-post").innerHTML = newPost;
  makeAPost();
}
renderHeaderAndPost();
function makeAPost() {
  const container = document.querySelector(".container"),
    privacy = container.querySelector(".post .privacy"),
    arrowBack = container.querySelector(".audience .arrow-back");
  // wrapper = document.querySelector(".wrapper"),

  privacy.addEventListener("click", () => {
    container.classList.add("show");
    // wrapper.style.justifyContent = "none";
  });

  arrowBack.addEventListener("click", () => {
    container.classList.remove("show");
  });
  const overlay = document.getElementById("overlay");
  const btnClick = document.getElementById("addPost");
  btnClick.addEventListener("click", () => {
    overlay.style.display = "flex";
    console.log("click");
  });
  document.getElementById("overlay").addEventListener("click", function (e) {
    if (e.target === document.getElementById("overlay")) {
      overlay.style.display = "none";
    }
  });
  document.getElementById("closeButton").addEventListener("click", function () {
    overlay.style.display = "none";
  });
}
////////////////////////////////////////////////////////////////
let prevScrollPos = window.pageYOffset;

window.onscroll = function () {
  let currentScrollPos = window.pageYOffset;
  prevScrollPos = currentScrollPos;
  if (prevScrollPos == 500 || prevScrollPos > 500) {
    document.getElementById("nav-site-profile").style.display = "flex";
  } else {
    document.getElementById("nav-site-profile").style.display = "none";
  }
};
///////////////////////////////
document.getElementById("profile").addEventListener("click", function () {
  if (document.getElementById("dropdown-profile").style.display === "none") {
    document.getElementById("dropdown-profile").style.display = "block";
  } else {
    document.getElementById("dropdown-profile").style.display = "none";
  }
});
document
  .getElementById("profile-setting")
  .addEventListener("click", function () {
    window.location.href = "/profile.html";
  });
