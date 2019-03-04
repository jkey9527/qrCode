$("#addUser").click(function() {
	$.ajax({
		type : 'post',
		data : $('#form').serialize(),
		url : '../../addUser.do',
		cache : false,
		dataType : 'text',
		success : function(data) {
			if ("fail" != data) {
				alert('保存成功');
			} else {
				alert('保存失败');
			}
		}
	})
})


