$().ready(function() {
	$("#login_form").validate({
		rules: {
			username: "required",
			password: {
				required: true,
				minlength: 5
			},
		},
		messages: {
			username: "请输入姓名",
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
		}
	});
	$("#register_form").validate({
		rules: {
			username: "required",
			password: {
				required: true,
				minlength: 5
			},
			rpassword: {
				equalTo: "#register_password"
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			username: "请输入姓名",
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
			rpassword: {
				equalTo: "两次密码不一样"
			},
			email: {
				required: "请输入邮箱",
				email: "请输入有效邮箱"
			}
		}
	});
});
$(function() {
	$("#register_btn").click(function() {
		$("#register_form").css("display", "block");
		$("#login_form").css("display", "none");
	});
	$("#back_btn").click(function() {
		$("#register_form").css("display", "none");
		$("#login_form").css("display", "block");
	});
	//登录功能
	$("#login_btn").click(function() {
		 $('#login_form').form('submit',{
             url: 'user_login',
             onSubmit: function(){
                 return $(this).form('validate');
             },
             success: function(result){
            	 alert(0);
                 if (result == null) return;
                 alert(1);
                 result = $.parseJSON(result);    //转换为json对象
                 alert(2);
                 var msg = result.message;
                 alert(3);
                 if (result.success) {
                     $.messager.alert("信息提示", msg, "info", function () {
                         window.location.href = 'index.jsp';
                     })
                 }else{
                     $.messager.alert("错误", "操作失败！" + msg, "error");
                 }
             }
         });
	});
	
});