$(document).ready(function () {
//    window.onload = function () {
    var sign = document.createElement("div");
    var body = document.getElementsByTagName("body")[0];
    var wrap = document.getElementById("wrap");
    var header = document.getElementById("header");
    sign.setAttribute("id", "sign");
    sign.innerHTML = "this is sign";
    var background = document.createElement("div");
    background.setAttribute("id", "background");
    background.addEventListener("click", function (e) {
        body.removeChild(this);
        wrap.removeChild(sign);
    });

    $('#signout').on('click', function () {
//        alert('sa');
        $.ajax({
            type: 'GET',
            url: 'Login',
            data: {signout: 'ok'
            },
            success: function (res) {
                console.log(res);
                if (res === 'ok') {
                    location.reload();
                }
            }
        });
    })
//    click(function () {
//        alert('sa');
//        $.ajax({
//            type: 'GET',
//            url: home,
//            data: {signout: 'ok'
//            },
//            success: function (res) {
//                location.reload();
//            }
//        });
//    });

    //--------show hide popup sign in ------------------------------------------//
    var profile = $("#profile");

    if (profile) {
        profile.on("click", function (e) {
            $("#sign").css({"z-index": "100", "display": "block"});
            $("#sign").animate({
                "opacity": "1"
            }, 500);
        });
        $('#sign').on('click', function (e) {
            if (e.target !== this)
                return;

            $('#sign').animate({
                opacity: "0"
            }, 500);
            setTimeout(() => {
                $("#sign").css({"z-index": "0", "display": "none"});
            }, 500);

        });
    }



    //------------------end show hide pupop sign in-----------------------------------//
    var nav = document.getElementById("nav");
    var current = document.documentElement.scrollTop;
//        console.log(current);
    window.addEventListener("scroll", function (e) {
//            console.log(current);
        if (document.documentElement.scrollTop > current) {
//                console.log(document.documentElement.sroolTop);
            nav.className = "nav";
            var t = parseInt($("header").css("height"), 10) - 50;
            var e = document.getElementsByClassName("nav");
            e[0].setAttribute("style", "top:" + t + "px");
            current = document.documentElement.scrollTop;
        } else {
            nav.className = "nav1";
            $(".nav1").css("top", $("header").css("height"));
            current = document.documentElement.scrollTop;
        }
    });

    $('#sign form').submit(function () {
        return false;
    });
//



    $("#ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_btnDangNhap").click(function () {
        $.ajax({
            type: 'POST',
            url: 'Login',
            data: {user: $('#ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa').val(),
                pass: $('#ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau').val()
            },
            success: function (res) {
                console.log(res);
                if (res !== "false") {
                    location.reload();
                } else {
                    alert('Sai mật khẩu hoặc tài khoản');
                }
                return false;
            }
        });
    });



});