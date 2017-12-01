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
<title>修改密码</title>
<jsp:include page="base/stylebase.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" type="text/css" rel="stylesheet"
	rev="stylesheet" />

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

</head>

<body>

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">修改密码</h2>
			
			<input type="text" id="inputEmail" name="oldPassword"
				class="form-control" placeholder="请输入旧密码" required autofocus>
				
			<input type="password" id="inputPassword" name="newPassword"
				class="form-control" placeholder="请输入新密码" required>
				
			<input type="password" id="inputPasswordAgain" name="againPassword"
				class="form-control" placeholder="请重复输入密码" required>
				
			<button class="btn btn-lg btn-primary btn-block" type="submit">修改密码</button>
		</form>

	</div>
	<!-- /container -->


</body>
</html>
