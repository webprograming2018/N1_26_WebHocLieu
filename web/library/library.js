$(document).ready(function () {
    function renderButton() {
        gapi.signin2.render('gSignIn', {
            'scope': 'profile email',
            'width': 240,
            'height': 50,
            'longtitle': true,
            'theme': 'dark',
            'onsuccess': onSuccess,
            'onfailure': onFailure
        });
    }

// Sign-in success callback
    function onSuccess(googleUser) {
        // Get the google profile data
        var profile = googleUser.getBasicProfile();

        // Get the google+ profile data
        alert('thanfh cong r nhe')
    }

// Sign-in failure callback
    function onFailure(error) {
        alert(error);
    }

// Sign out the user
    
});