<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PTIT STUDY</title>
        <!--<link rel="stylesheet" type="text/css" href="../header.css">-->
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
              crossorigin="anonymous">


        <script type="text/javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" src="./js/javascript.js"></script>
    </head>
    <body>
        <%@page import="javax.servlet.http.HttpSession" %>
        <%  int i; // i = 1 la da dang nhap, i = 0 la chua dang nhap
            String user = null;
            session = request.getSession();
            if (session.isNew()) {
                session.setAttribute("user", "");
                i = 0;
            } else {
                user = session.getAttribute("user").toString();
                if (user.equals("")) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
        %>
        <header id="header">
            <div class ="wrap">
                <div id="logo"></div><% //
                    if (i == 0) {%>
                <div id="profile" class="text">Sign In</div>
                <% } else {%>
                <div id='admin' class="text">
                    <%=session.getAttribute("name").toString()%>
                </div>
                <div id="signout" class="text">Sign out</div>
<!--                <scrip>
                    function signout(){
                    alert('a');
                    }
                </scrip>-->

                <% }
                %>
                <div id="search_area">
                    <input type="text" name="text_search" id="text_search" placeholder="type content to search" class="text">
                    <button id="search" class="text">Search</button>
                </div>
            </div>
        </header>
        <div class="wrap">
            <nav id="nav" class="nav2">
                <ul>
                    <li title="Home">
                        <a href="home">HOME</a>
                    </li>
                    <li title="study process">
                        <a>Study Process</a>
                        <ul id="case_study">
                            <li title="study C"><a href='studyweb'>STUDY WEB</a></li>
                            <li title="study java"><a href="#">STUDY JAVA</a></li>
                            <li title="study javascript"><a href="#">STUDY JAVASCRIPT</a></li>
                        </ul>
                    </li>
                    <li title="library">
                        <a href="library">Library</a>
                    </li>
                    <li>
                        <a href ='viewwork'>View Work</a>
                    </li>
                    <li title="profile">
                        <a href="profile.html">Profile</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="sign" class="main-content-agile">
            <div class="popup">
                <h2>Using PTIT Account</h2>
                <form name="aspnetForm" method="post" id="aspnetForm">
                    <input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
                    <input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />

                    <!-- <div> -->

                    <!-- <input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="CA0B0334" /> -->
                    <!-- </div> -->
                    <div class="field mr-bottom">
                        <span class="fa fa-user-o" aria-hidden="true"></span>
                        <input placeholder="User" name="ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa" type="text" id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa"
                               required />
                    </div>
                    <div class="field">
                        <span class="fa fa-key" aria-hidden="true"></span>
                        <input placeholder="Password" name="ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau" type="password" id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau"
                               required />
                    </div>
                    <p class="error">
                    </p>
                    <div class="sub">
                        <a id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_lnkBtnQuenMK" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$lnkBtnQuenMK','')">Forgot password!</a>
                    </div>
                    <div class="submit">
                        <input type="submit" name="ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$btnDangNhap" value="Sign In" id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_btnDangNhap" />
                    </div>
                </form>
            </div>
        </div>
