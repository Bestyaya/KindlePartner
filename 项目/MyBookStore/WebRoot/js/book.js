function view_cart() {
	window.location.href = "viewCart.jsp";
}

function do_submit() {
	var msg = "Are you sure you want to add to the shopping cart";
	if (confirm(msg) === true)
		submit();
}

function submit() {
	$.ajax({
		type : 'post',
		url : 'cart_submit',
		dataType : 'json',
		success : function(result) {
			alert(0);
			if (result == null)
				return;
			alert(1);
			result = $.parseJSON(result); // 转换为json对象
			alert(2);
			var msg = result.message;
			alert(3);
			if (result.success) {
				alert(msg);
			} else {
				alert(msg);
			}
		}
	})
}