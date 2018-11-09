$(document).ready(function () {

    // show hide menu
    $('.icon-menu').click(function () {
        $('.menu-content').toggle();
    });
    $(document).click(function (event) {
        if (!$(event.target).closest(".icon-menu, .menu-content").length) {
            $(".menu-content").hide();
        }
    });

    var table = $(".table-body tbody");
    var data;
    // load data======================================================
    $.ajax({
        url: "https://raw.githubusercontent.com/quangvuong97/LTW/master/page/json/ql.json",
        dataType: "json",
        success: function (_data) {
            data = new Data(_data);
            data.show();
            editTable();
        }
    })

    //Object data 
    function Data(data) {
        this.Data = data;
        // this.sortUP = function (sortby) {
        //     this.Data.sort(function (a, b) {
        //         if (sortby === "one" || sortby === "two" || sortby === "three" || sortby === "four" || sortby === "five" || sortby === "mark") {
        //             return a[sortby] - b[sortby];
        //         } else
        //             return a[sortby].localeCompare(b[sortby]);
        //     });
        // }
        // this.sortDown = function (sortby) {
        //     this.Data.sort(function (a, b) {
        //         if (sortby === "one" || sortby === "two" || sortby === "three" || sortby === "four" || sortby === "five" || sortby === "mark") {
        //             return b[sortby] - a[sortby];
        //         } else
        //             return b[sortby].localeCompare(a[sortby]);
        //     });
        // }
        this.show = () => {
            table.empty();
            $.each(this.Data, function (index, value) {
                var rowspan = 3;
                value.member[1].studentName === '' ? rowspan = 1 : (value.member[2].studentName === '' ? rowspan = 2 : null);
                var recode = "<tr>" +
                        `<td class='group' rowspan='${rowspan}'><p>${value.group}</p></td>` +
                        `<td class='studentName'><p>${value.member[0].studentName}</p></td>` +
                        `<td class='studentCode'><p>${value.member[0].studentCode}</p></td>` +
                        `<td class='project' rowspan='${rowspan}'><p>${value.project}</p></td>` +
                        `<td class='require one' rowspan='${rowspan}'><p>${value.one.require1}</p></td>` +
                        `<td class='require one' rowspan='${rowspan}'><p>${value.one.require2}</p></td>` +
                        `<td class='require one' rowspan='${rowspan}'><p>${value.one.require3}</p></td>` +
                        `<td class='require two' rowspan='${rowspan}'><p>${value.two.require1}</p></td>` +
                        `<td class='require two' rowspan='${rowspan}'><p>${value.two.require2}</p></td>` +
                        `<td class='require two' rowspan='${rowspan}'><p>${value.two.require3}</p></td>` +
                        `<td class='require three' rowspan='${rowspan}'><p>${value.three.require1}</p></td>` +
                        `<td class='require three' rowspan='${rowspan}'><p>${value.three.require2}</p></td>` +
                        `<td class='require three' rowspan='${rowspan}'><p>${value.three.require3}</p></td>` +
                        `<td class='document' rowspan='${rowspan}'><a href='${value.document}' target='_blank'> ${value.document} </td>` +
                        `<td class='sourceCode' rowspan='${rowspan}'><a href='${value.sourceCode}' target='_blank'> ${value.sourceCode} </td>` +
                        "</tr>";
                if (value.member[1].studentName !== '') {
                    recode += "<tr>" +
                            `<td class='studentName'><p>${value.member[1].studentName}</p></td>` +
                            `<td class='studentCode'><p>${value.member[1].studentCode}</p></td>` +
                            "</tr>";
                }
                if (value.member[2].studentName !== '') {
                    recode += "<tr>" +
                            `<td class='studentName'><p>${value.member[2].studentName}</p></td>` +
                            `<td class='studentCode'><p>${value.member[2].studentCode}</p></td>` +
                            "</tr>";
                }



                table.append(recode)
            });
            spShow();
        }
    }

    //search data======================================================
    $("input:text").keyup(function () {
        var group = $('#group').hasClass('none') ? new RegExp() : RegExp($("input:text[name='group']").val());
        var studentCode = $('#studentCode').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='studentCode']").val().toLowerCase());
        var studentName = $('#studentName').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='studentName']").val().toLowerCase());
        var project = $('#project').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='project']").val().toLowerCase());
        var one1 = $('#one').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='one1']").val());
        var one2 = $('#one').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='one2']").val());
        var one3 = $('#one').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='one3']").val());
        var two1 = $('#two').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='two1']").val());
        var two2 = $('#two').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='two2']").val());
        var two3 = $('#two').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='two3']").val());
        var three1 = $('#three').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='three1']").val());
        var three2 = $('#three').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='three2']").val());
        var three3 = $('#three').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='three3']").val());
        var document = $('#document').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='document']").val().toLowerCase());
        var sourceCode = $('#sourceCode').hasClass('none') ? new RegExp() : new RegExp($("input:text[name='sourceCode']").val().toLowerCase());

        console.log(group);
        console.log(studentName);
        console.log(studentCode);
        console.log(project);
        console.log(one1);
        console.log(one2);
        console.log(one3);
        console.log(two1);
        console.log(two2);
        console.log(two3);
        console.log(three1);
        console.log(three2);
        console.log(three3);
        console.log(document);
        console.log(sourceCode);
        var result = new Data(jQuery.map(data.Data, function (obj) {
            if (group.test(obj.group) && project.test(obj.project) && one1.test(obj.one.require1) && one2.test(obj.one.require2) && one3.test(obj.one.require3) && two1.test(obj.two.require1) && two2.test(obj.two.require2) && two3.test(obj.two.require3) && three1.test(obj.three.require1) && three2.test(obj.three.require2) && three3.test(obj.three.require3) && (studentName.test(obj.member[0].studentName.toLowerCase()) || studentName.test(obj.member[1].studentName.toLowerCase()) || studentName.test(obj.member[2].studentName.toLowerCase())) && (studentCode.test(obj.member[0].studentCode.toLowerCase()) || studentCode.test(obj.member[1].studentCode.toLowerCase()) || studentCode.test(obj.member[2].studentCode.toLowerCase()))) {
                return obj; // or return obj.name, whatever.
            }
        }));

        // result.sortUP("studentCode");
        result.show();
    })


    //sort data=======================================================
    // $(".head-table th").click(function (e) {
    //     if ($(this).hasClass("sort")) {
    //         if ($(this).hasClass("down")) {
    //             $(this).removeClass("down");
    //             $(this).addClass("up");
    //             $(this).find("i").removeClass();
    //             $(this).find("i").addClass("fas fa-long-arrow-alt-up");
    //             data.sortUP($(this).attr('id'));
    //         } else {
    //             $(this).removeClass("up");
    //             $(this).addClass("down");
    //             $(this).find("i").removeClass();
    //             $(this).find("i").addClass("fas fa-long-arrow-alt-down");
    //             data.sortDown($(this).attr('id'));
    //         }
    //     } else {
    //         $(".head-table th").removeClass("sort");
    //         $(".head-table th").removeClass("down");
    //         $(".head-table th").removeClass("up");
    //         $(".head-table th").find("i").removeClass();
    //         $(".head-table th").find("i").addClass("fas fa-sort");
    //         $(this).addClass("sort");
    //         $(this).addClass("up");
    //         $(this).find("i").removeClass();
    //         $(this).find("i").addClass("fas fa-long-arrow-alt-up");
    //         data.sortUP($(this).attr('id'));
    //     }
    //     data.show();
    // })

    //show hide col table
    $('input[type="checkbox"]').change(function () {
        var cla = $(this).attr('name');
        if (this.checked) {
            $(`.${cla}`).removeClass('none');
        } else {
            $(`.${cla}`).addClass('none');
        }
        editTable();
    })

    //edit display col member
    function editTable() {
        var studentCode = $('#studentCode');
        var studentName = $('#studentName');

        if (studentCode.hasClass('none') && studentName.hasClass('none')) {
            $('.member').addClass('none');
        } else {
            $('.member').removeClass('none');
            if (!studentCode.hasClass('none') && !studentName.hasClass('none')) {
                $('.member').attr('colspan', '2');
            } else {
                $('.member').attr('colspan', '1');
            }
        }

    }

    //edit show hide
    function spShow() {
        $('input[type="checkbox"]').each(function () {
            if (!this.checked) {
                $(`.${$(this).attr('name')}`).addClass('none');
            }
        })
    }

})