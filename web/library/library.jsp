<jsp:include page="header.jsp"></jsp:include>
    <div id="wrap" class="wrap">
        <main>
            <article>
                <div id="my-signin2"></div>
                <div id='link'></div>
                <button id='g-signout' style="display: none">sign out</button>
                <script>
                    function onSuccess(googleUser) {
                        googleUser.getBasicProfile().getName();
                        console.log("ok");
                        var link = document.createElement("a");
                        $.ajax({
                            type: 'GET',
                            url: 'downloadServlet',
                            success: function (res) {
                                $('#my-signin2').css("display", "none");
                                $('#g-signout').css("display", "block");
                                $('#g-signout').css("float", "right");
                                link.setAttribute("href", res);
                                console.log(res);
                                link.innerHTML = res;
                                $('#link').append(link);
                            }
                        });
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

                    $('#g-signout').click(function () {
                        var auth2 = gapi.auth2.getAuthInstance();
                        auth2.signOut().then(function () {
                            $('#my-signin2').css("display", "block");
                            $('#g-signout').css("display", "none");
                            $('#link').html("");
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
