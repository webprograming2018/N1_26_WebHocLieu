<%@page import="java.util.ArrayList"%>
<%@page import="model.File"%>
<%@page import="control.FileDAO"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrap" class="wrap">
    <main>
        <article>
            <div id="my-signin2"></div>
            <div id="showFile" style="display: none">
                <%FileDAO fileDAO = new FileDAO("LapTrinhWeb", "sa", "1");
                    ArrayList<model.File> listFile = fileDAO.getListFile();
                    for (int i = 0; i < listFile.size(); i++) {%>
                    <div><a href="<%=listFile.get(i).getLink()%>" target='blank'><%=listFile.get(i).getFileName()%></a></div>
                <%}
                %>
            </div>
        </article>
        <aside>     
            <div id="library" style="display: none">
                <div id='dropbox'>
                    <form action="Upload" method="post" enctype="multipart/form-data">
                        <div class="file-box">
                            <div class="box-con">
                                <input type="file" name="file" id="file" />
                                <label tabindex="0" for="file" class="input-file-trigger">Chọn một tệp...</label>
                                <p class="file-return"></p>
                            </div>
                        </div>
                        <div class="file-box2">
                            <select class="category" name="category">
                                <option value="TTDPT">TTDPT</option>
                                <option value="DTVT">DTVT</option>
                                <option value="CNTT">CNTT</option>
                                <option value="ATTT">ATTT</option>
                                <option value="OTHER">OTHER</option>
                            </select>
                            <input type="submit" class="submit" />
                        </div>
                        <!--<button class="cancel">CANCEL</button>-->
                    </form>
                </div>
                <button class="signout">signout Google Account</button>
            </div>
        </aside>
        <script>
//            $("#showFile").hide();
            function onSuccess(googleUser) {
                googleUser.getBasicProfile().getName();
                console.log("ok");
                $('#my-signin2').css("display", "none");
                $('#library').css("display", "block");
                $('#library').css("float", "right");
                $('#showFile').css("display", "block");
                $('#dropbox form').submit(function () {
                    return false;
                });
                
//                $("#showFile").show();

//                $.ajax({
//                    url: "UploadServlet", //You can replace this with MVC/WebAPI/PHP/Java etc
//                    method: "get",
//                    success: function (res) {
//                        console.log(res);
//                        Element a = 
//                        $("#showFile").appen
//                    },
//                    error: function (error) {
//                        console.log(error);
//                    }
//
//                });

                $('.submit').on('click', function () {

                    var files = $("#file")[0];
                    console.log(files.name);
                    console.log(files.files[0].name);
//
                    var formData = new FormData();
//
                    formData.append(files.name, files.files[0]);
                    formData.append("category", $(".category").val());

                    $.ajax({
                        url: "UploadServlet", //You can replace this with MVC/WebAPI/PHP/Java etc
                        method: "post",
                        data: formData,
                        contentType: false,
                        processData: false,
                        success: function (res) {
                            console.log(res);
                            alert("Upload Completed");
                        },
                        error: function (error) {
                            console.log(error);
                        }

                    });
                });

//                    $.ajax({
//                        type: 'GET',
//                        url: 'downloadServlet',
//                        success: function (res) {
//                            
//                        }
//                    });
            }



            function onFailure(error) {
                console.log(error);
            }
            function renderButton() {
                gapi.signin2.render('my-signin2', {
                    'scope': 'profile email',
                    'width': 240,
                    'height': 50,
                    'longtitle': true,
                    'theme': 'dark',
                    'onsuccess': onSuccess,
                    'onfailure': onFailure
                });
            }

            $('.signout').click(function () {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    $('#my-signin2').css("display", "block");
                    $('#library').css("display", "none");
                    $('#showFile').css("display", "none");
                });

                auth2.disconnect();

            });

            var fileInput = $("#file"),
                    the_return = document.querySelector(".file-return");

            $(".input-file-trigger").on("keydown", function (event) {
                if (event.keyCode == 13 || event.keyCode == 32) {
                    fileInput.focus();
                }
            });
            $(".input-file-trigger").on("click", function () {
                fileInput.focus();
            });
            fileInput.on("change", function (event) {
                the_return.innerHTML = this.value;
            });
        </script>

        <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>

    </main>
</div>
<!--    <script type="text/javascript" src="./library/library.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>-->
<!--<script>-->

<jsp:include page="footer.jsp"></jsp:include>
