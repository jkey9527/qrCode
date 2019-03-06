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

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
Date.prototype.Format = function (fmt) {
 var o = {
     "M+": this.getMonth() + 1, //月份 
     "d+": this.getDate(), //日 
     "H+": this.getHours(), //小时 
     "m+": this.getMinutes(), //分 
     "s+": this.getSeconds(), //秒 
     "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
     "S": this.getMilliseconds() //毫秒 
 };
 if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
 for (var k in o)
 if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
 return fmt;
}

