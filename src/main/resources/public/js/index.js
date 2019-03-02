var vue;



function logout(){
    //清除当前登录的用户信息
    location.href = "login.html";
}

//动态显示模态框
function showModal(title, body, callback, type){

    var myModal = $("#myModal");

    $("#myModal .modal-title").html(title);
    $("#myModal .modal-title").css('color', '#fff');
    $("#myModal .modal-body p").html(body);

    if(!type){
        type = 'normal';
    }
    switch (type) {
        case 'normal':
            $("#myModal .modal-header").css('background','#5bc0de');
            break;
        case 'warn':
            $("#myModal .modal-header").css('background','#f0ad4e');
            break;
        case 'error':
            $("#myModal .modal-header").css('background','#d9534f');
            break;
        default:
            break;
    }

    if(callback){//show ok
        $("#ok").css("display","inline-block");
        $("#ok").unbind("click");//绑定前清空，防止多次绑定
        $("#ok").click(callback);
    }else{
        $("#ok").css("display","none");
    }

    myModal.modal("show");
}

function closeModal(){
    $("#myModal").modal("hide");
}

/**
 * 初始化分页
 * @param pageCount 总页数
 * @param callback 回调函数
 * @param showPage 当前分页导航显示多少页，默认为10
 * @param activePage 当前所在的页面位置，默认为1
 * @param startVal 开始计数的位置，默认为1
 */
function initPagination(pageCount, callback, showPage, activePage, startVal) {
    if(!callback){
        return;
    }
    if(!showPage){
        showPage = 10;
    }
    if(!startVal){
        startVal = 1;
    }
    if(!activePage){
        activePage = 1;
    }

    var pagination = $("#pager .pagination");
    $("#pager").css("display", "block");

    var addline = "";

    if (pageCount <= showPage) {

        for (var i = startVal; i <= pageCount; i++) {
            if(i==activePage){
                addline += '<li class="active"><a href="#">' + i + '</a></li>';
            }else{
                addline += '<li><a href="#">' + i + '</a></li>';
            }
        }
    } else {
        addline += '<li>\n' +
            '\t\t\t\t<a href="#" aria-label="Previous">\n' +
            '\t\t\t\t\t<span aria-hidden="true">prev</span>\n' +
            '\t\t\t\t</a>\n' +
            '\t\t\t</li>';
        for (var i = startVal; i < startVal + showPage; i++) {
            if(i==activePage){
                addline += '<li class="active"><a href="#">' + i + '</a></li>';
            }else{
                addline += '<li><a href="#">' + i + '</a></li>';
            }
        }
        addline += '<li>\n' +
            '\t\t\t\t<a href="#" aria-label="Next">\n' +
            '\t\t\t\t\t<span aria-hidden="true">next</span>\n' +
            '\t\t\t\t</a>\n' +
            '\t\t\t</li>';
    }

    pagination.html(addline);

    pagination.children().each(function (idx, item) {
        $(item).unbind("click");
        $(item).click(function () {
            var c = $(item).find('a');
            var clickVal = c[0].innerText;//当前点击的页码
            if(clickVal=='prev'){
                var nextNode = $(item).next();
                var nextNodeVal = nextNode[0].innerText;
                if(nextNodeVal > 1){
                    initPagination(pageCount, callback, showPage, activePage, nextNodeVal-1);
                }else{
                    $(item).addClass("disabled");
                }
            }else if(clickVal=='next'){
                var prevNode = $(item).prev();
                var prevNodeVal = prevNode[0].innerText;
                if(prevNodeVal < pageCount){
                    initPagination(pageCount, callback, showPage, activePage, prevNodeVal-showPage+2);
                }else{
                    $(item).addClass("disabled");
                }
            }else{
                $(item).siblings().each(function (idx,item) {
                    var flag = $(item).hasClass("active");
                    if(flag){
                        $(item).removeClass("active");
                    }
                });
                $(item).addClass("active");
                activePage = clickVal;
                callback(clickVal);
            }
        })
    })
}

function closePagination() {
    $("#pager").css("display", "none");
}



$(function(){
    vue = new Vue({
        el: '#content',
        data: {
            'menus': [
                {
                    'id': 1,
                    'name': '用户管理',
                    'icon': 'glyphicon-credit-card',
                    'menu': [
                        {
                            'name': '新增用户',
                            'url': 'html/user/addUser.html'
                        },
                        {
                            'name': '修改用户',
                            'url': 'html/user/updateUser.html'
                        },
                        {
                            'name': '删除用户',
                            'url': 'html/user/deleteUser.html'
                        },
                        {
                            'name': '查询用户',
                            'url': 'html/user/findUser.html'
                        }
                    ]
                },
                {
                    'id': 2,
                    'name': '活动管理',
                    'icon': 'glyphicon-book',
                    'menu': [
                        {
                            'name': '新增活动',
                            'url': 'html/activity/addActivity.html'
                        },
						{
                            'name': '修改活动',
                            'url': 'html/activity/updateActivity.html'
                        },
						{
                            'name': '删除活动',
                            'url': 'html/activity/deleteActivity.html'
                        },
						{
                            'name': '废弃活动',
                            'url': 'html/activity/discardActivity.html'
                        },
						{
                            'name': '查询活动',
                            'url': 'html/activity/findActivity.html'
                        }
						
                    ]
                },
                {
                    'id': 3,
                    'name': '用户-活动管理',
                    'icon': 'glyphicon-file',
                    'menu': [
                        {
                            'name': '邀请用户',
                            'url': 'html/userActivity/invite.html'
                        },
						{
                            'name': '取消邀请',
                            'url': 'html/userActivity/cancel.html'
                        }
                    ]
                },
                {
                    'id': 4,
                    'name': '签到统计',
                    'icon': 'glyphicon-duplicate',
                    'menu': [
                        {
                            'name': '查询签到情况',
                            'url': 'html/sign/statistics.html'
                        }
                    ]
                },
                {
                    'id': 5,
                    'name': '签到',
                    'icon': 'glyphicon-cog',
                    'menu': [
                        {
                            'name': '用户签到',
                            'url': 'html/code/code.html'
                        }
                    ]
                }
            ]
        },
        methods: {
            openOrClose: function(num){
                var ele = $("#"+num);
                var flag = ele.css("display");
                if(flag && flag!="none"){
                    ele.slideUp();
                }else{
                    ele.slideDown();
                }
            },

            openUrl: function(url){
                $("#main iframe").attr("src", url);
            }
        }
    });

    //判断当前用户是否处于登录状态
    var flag = true;
    if(!flag){
        location.href = "login.html";
    }

    // 这样做的原因是bootstrap.js的问题，会覆盖jquery的slide方法
    vue.openOrClose(1);
    vue.openOrClose(2);
    vue.openOrClose(3);
    vue.openOrClose(4);
    vue.openOrClose(5);
    $("#header").click();
    vue.openOrClose(1);

});
