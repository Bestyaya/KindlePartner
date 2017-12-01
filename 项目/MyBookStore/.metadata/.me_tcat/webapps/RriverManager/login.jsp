<%--
  Created by IntelliJ IDEA.
  User: 412
  Date: 2017/5/22
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>登录</title>
<jsp:include page="base/stylebase.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" type="text/css" rel="stylesheet"
	rev="stylesheet" />
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
                url: 'user_login',
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result == null) return;
                    result = $.parseJSON(result);    //转换为json对象
                    //result = $.parseJSON(result.json);   //取出json数据来再转换为json对象
                    var msg = result.message;
                    if (result.success) {
                        $.messager.alert("信息提示", msg, "info", function () {
                            window.location.href = 'main.jsp';
                        })
                    }else{
                        $.messager.alert("错误", "操作失败！" + msg, "error");
                    }
                }
            });
		}
	</script>
</head>
<body class="login">
	<div class="dl">
		<div class="title">
			<img src="css/images/ico02.jpg" />
		</div>
		<form name="form" id="form" method="post" action="user_login"
			autocomplete="off">
			<div class="log">
				<ul class="xuzhi02">
					<img src="images/earth.jpg" />
				</ul>
				<ul class="deng02">
					<br>
					<li style=" width:100%; height:60px;"><label>账号：</label> <input
						id="loginid" name="user.loginid" style="height: 35px;width: 300px"
						class="easyui-textbox" required="true" missingMessage="填写账号" /></li>
					<div style="clear:both;"></div>

					<li style=" width:100%; height:40px;"><label>密码：</label> <input
						id="password" name="user.password" type="password"
						style="height: 35px;width: 300px" class="easyui-textbox"
						required="true" missingMessage="填写密码" /></li>
					<li style=" width:100%;">
						<p style="margin-left: 270px">
							<a href="register.jsp" class="regbtn">新用户注册</a>
						</p>
						<button id="logonbtn" class="btn-login02" onclick="checkData()"
							type="button" style="margin-left: 110px;width: 200px">
							<span>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</span>
						</button></li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>
