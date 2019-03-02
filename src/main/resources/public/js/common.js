function checkAll() {
    var flag = $("input[name='all']:checked").length;
    var checkBox = $("input[name='single']");
    if(flag > 0){
        checkBox.each(function () {
            this.checked = true;
        });
    }else{
        checkBox.each(function () {
            this.checked = false;
        });
    }
    $("input[name='single']").each(function (idx, item) {
        $(item).unbind("click");
        $(item).click(function () {
            var checkedCount = $("input[name='single']:checked").length;
            if(checkedCount==0){
                $("input[name='all']")[0].checked = false;
            }else if(checkedCount == checkBox.length){
                $("input[name='all']")[0].checked = true;
            }
        });
    })
}

//日期格式
formatDate = function (date) {
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return year + '年' + month + '月' + day + '日';
}

//初始化界面按钮
function initOpBtn(){
    var btns = $(".btn-entry");
    var btnsCount = $(btns).children().length;
    btns.css("left",($(window).width() - 41*btnsCount));
}