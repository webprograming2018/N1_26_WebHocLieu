$(document).ready(function () {

    $.ajax({
        type: 'GET',
        url: 'StudyWebSV',
        success: update
    });


    function update(json) {
        console.log(json);
        jsonObject = JSON.parse(json);
        var content = document.createElement("div");
        content.innerHTML = jsonObject[0].noiDung;
        var code = document.createElement("div");
        code.innerHTML = jsonObject[0].code;
        $("article:first").append(content);
        $("aside:first").append(code);
//    var listA = new Array();
//    for (var i = 0; i < jsonObject.length; i++){
//        var a = document.createElement("a");
//        a.innerHTML = jsonObject[i].tenBai;
//        a.addEventListener("click",function(){
//            var article = document.getElementsByTagName("article")[0].innerHTML = '';
//            article.append()
//        });
//        listA.push(a);
//        var br = document.createElement("br");
//        $("aside:first").append(a);
//        $("aside:first").append(br);
//    }
    }
    var jsonObject;
});