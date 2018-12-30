<%@page import="java.util.ArrayList"%>
<%@page import="java.net.CookieManager"%>
<%@page import="java.net.CookieHandler"%>
<%@page import="model.Qldt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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


        <!--<script src="https://apis.google.com/js/client:platform.js?onload=renderButton" async defer></script>-->
        <meta name="google-signin-client_id" content="785882447208-cnnkdb3q86glg81ftiil2tdovtugsqrg.apps.googleusercontent.com">

        <script type="text/javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" src="./js/javascript.js"></script>
    </head>
    <body>
        <%@page import="javax.servlet.http.HttpSession" %>        
        <%  int i; // i = 1 la da dang nhap, i = 0 la chua dang nhap
            String user = null;
            String pass = null;
            session = request.getSession();
            if (session.isNew()) {
                session.setAttribute("user", "");
                i = 0;
            } else {
                try {
                    user = session.getAttribute("user").toString();
                    pass = session.getAttribute("pass").toString();
                    if (user.equals("")) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                } catch (Exception e) {
                    i = 0;
                    session.setAttribute("user", "");
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
                            <% if (i == 1) {
                                    String mainQLDT = "http://qldt.ptit.edu.vn/";
                                    String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";

                                    Qldt http = new Qldt();

                                    CookieHandler.setDefault(new CookieManager());

                                    try {
                                        http.GetCookie(mainQLDT);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                    String postParams = http.getFormParams(user, pass);
                                    String name = "";
                                    ArrayList<String> listMH = new ArrayList<String>();
                                    String[] listMa = new String[10];
                                    try {
                                        name = http.sendPost(defaultQLDT, postParams);
                                        listMH = http.getMonHoc(listMa);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                        response.getWriter().write(ex.toString());
                                    }
                                    for (int j =0; j < listMH.size(); j++){
                                        String tmp = listMH.get(j);
                            %>

                            <li title="<%=tmp%>"><a href='studyweb?id=<%=listMa[j]%>&bai=bai1'><%=tmp%></a></li>
                                <%}} else {%>
                            <!--<li title="study C"><a href='home'>STUDY WEB</a></li>-->
                            <%}%>
                            <!--<li title="study java"><a href="#">STUDY JAVA</a></li>-->
                            <!--<li title="study javascript"><a href="#">STUDY JAVASCRIPT</a></li>-->
                        </ul>
                    </li>
                    <li title="library">
                        <a href="library">Library</a>
                    </li>
                    <% if (i == 1) {%>
                    <li><a href ='viewwork'>View Work</a></li>
                        <%} else {%>
                    <li><a href ='home'>View Work</a></li>
                        <%}%>
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
