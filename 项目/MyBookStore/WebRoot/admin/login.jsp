<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="cn.gov.entity.User"%>
<html>
<head>
<title>管理员登录</title>
<jsp:include page="../base/stylebase.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" type="text/css" rel="stylesheet"
	rev="stylesheet" />
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript">
		function checkData(){
			if($('#loginid').val()==""){
				$.messager.alert("提示信息", "请输入账号信息。", "info");
			}else if($('#password').val()==""){
				$.messager.alert("提示信息", "请输入密码信息。", "info");
			}else{
				doLogin();
			}
		}
		
		//执行登录
		/**
		 * 返回的数据的格式为：{"json":{},"user":{}}
		 * @memberOf {TypeName} 
		 * @return {TypeName} 
		 */
		function doLogin(){
            $('#form').form('submit',{
                url: 'admin_Login',
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result == null) return;
                    result = $.parseJSON(result);    //转换为json对象
                    var msg = result.message;
                    if (result.success) {
                        $.messager.alert("信息提示", msg, "info", function () {
                            window.location.href = 'admin_bookManager';
                        })
                    }else{
                        $.messager.alert("错误", "操作失败！" + msg, "error");
                    }
                }
            });
		}
	</script>
</head>

<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container" id="login-area">
	<div class="col-md-5 col-md-offset-1" id="login-form">
		<form method="post" id="form" name="form">
			<h2>Sign In Your Account</h2>
			<fieldset>
				<div class="form-group">
					<div class="input-group input-group-lg">
						<span class="input-group-addon"><span
							class="fa fa-user fa-fw"></span> </span> <label for="username"
							class="sr-only"> Admin ID </label> <input id="name" type="text"
							placeholder="Author ID" class="form-control" name="admin.name"
							value="">
					</div>
					<div class="input-group input-group-lg">
						<span class="input-group-addon"><span
							class="fa fa-key fa-fw"></span> </span> <label for="password"
							class="sr-only"> Password </label> <input id="password"
							type="password" placeholder="Password" class="form-control"
							name="admin.password">
					</div>
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-block btn-lg"
						onclick="checkData()">Sign In</button>
				</div>
			</fieldset>
		</form>
	</div>
</div>

</body>
</html>

