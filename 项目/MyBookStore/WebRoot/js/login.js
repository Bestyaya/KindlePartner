$().ready(function() {
	$("#login_form").validate({
		rules : {
			username : "required",
			password : {
				required : true,
				minlength : 5
			}
		},
		messages : {
			username : "请输入姓名",
			password : {
				required : "请输入密码",
				minlength : jQuery.format("密码不能小于{0}个字 符")
			}
		}
	});
	$("#register_form").validate({
		rules : {
			username : "required",
			password : {
				required : true,
				minlength : 5
			},
			rpassword : {
				equalTo : "#register_password"
			},
			email : {
				required : true,
				email : true
			}
		},
		messages : {
			username : "请输入姓名",
			password : {
				required : "请输入密码",
				minlength : jQuery.format("密码不能小于{0}个字 符")
			},
			rpassword : {
				equalTo : "两次密码不一样"
			},
			email : {
				required : "请输入邮箱",
				email : "请输入有效邮箱"
			}
		}
	});
});


$(function() {
	
	//点击注册按钮显示注册表单，隐藏登录表单
	$("#register_btn").click(function() {
		$("#register_form").css("display", "block");
		$("#login_form").css("display", "none");
	});
	
	//点击返回按钮，隐藏注册按钮，显示登录表单
	$("#back_btn").click(function() {
		$("#register_form").css("display", "none");
		$("#login_form").css("display", "block");
	});
	
	//
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