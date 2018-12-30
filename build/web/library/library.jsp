<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrap" class="wrap">
    <main>
        <article>
            <div id="my-signin2"></div>
            <div id='link'></div>
            <div id="library" style="display: none">
                <div id='dropbox'>
                    <form action="Upload" method="post" enctype="multipart/form-data">
                        <input type="file" name="file" id="file" /><br><br>
                        <select class="category" name="category">
                            <option value="image">image</option>
                            <option value="doccument">doccument</option>
                            <option value="Video">Video</option>
                        </select>
                        <input type="submit" class="submit" />
                        <!--<button class="cancel">CANCEL</button>-->
                    </form>
                </div>
                <button class="signout">sign out</button>
            </div>
            <script>
                function onSuccess(googleUser) {
                    googleUser.getBasicProfile().getName();
                    console.log("ok");
                    $('#my-signin2').css("display", "none");
                    $('#library').css("display", "block");
                    $('#library').css("float", "right");
                    $('#dropbox form').submit(function () {
                        return false;
                    });

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

                $('#signout').click(function () {
                    var auth2 = gapi.auth2.getAuthInstance();
                    auth2.signOut().then(function () {
                        $('#my-signin2').css("display", "block");
                        $('#library').css("display", "none");
                    });

                    auth2.disconnect();

                });
            </script>

            <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
        </article>
        <aside>                    
        </aside>				
    </main>
</div>
<!--    <script type="text/javascript" src="./library/library.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>-->
<!--<script>-->

<jsp:include page="footer.jsp"></jsp:include>
