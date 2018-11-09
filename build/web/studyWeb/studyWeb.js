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
        var tenBai = document.createElement("div");
        tenBai.innerHTML = jsonObject[0].tenBai;
        $("article:first").append(content);
        $("aside:first").append(tenBai);
        $.ajax({
            type: 'GET',
            url: jsonObject[0].code,
            success: function (data) {
                console.log(data);
                var code = $("<div id='editor' style='height:500px'></div>").text(data);
//                code.setAtrribute('id','editor');
//                code.innerHTML = data;
//$("aside:first")
                console.log(code);
                $("article:first").append(code);
                var editor = ace.edit("editor");
                editor.setTheme("ace/theme/dracula");
                editor.session.setMode("ace/mode/java");
            }
        });
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

//    var beautify = ace.require("ace/ext/beautify");

//    beautify.beautify(editor.session);
    var jsonObject;
});