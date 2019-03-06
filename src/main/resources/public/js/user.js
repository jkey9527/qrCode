//按钮保存事件
$("#addUser").click(function() {
	$.ajax({
		type : 'post',
		data : $('#form').serialize(),
		url : '../../addUser.do',
		cache : false,
		dataType : 'text',
		success : function(data) {
			if ("success" == data) {
				alert('保存成功');
			} else {
				alert(data);
			}
			$('#form')[0].reset();
		}
	})
})
//按钮修改事件
$("#updateUser").click(function() {
	$.ajax({
		type : 'post',
		data : $('#form').serialize(),
		url : '../../updateUser.do',
		cache : false,
		dataType : 'text',
		success : function(data) {
			if ("success" == data) {
				alert('修改成功');
			} else {
				alert(data);
			}
			$('#form')[0].reset();
		}
	})
})


