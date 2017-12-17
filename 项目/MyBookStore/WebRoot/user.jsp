<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="cn.gov.entity.User"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.gov.entity.Book"%>
<html>
<head>
<title>导航栏</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" type="text/css" rel="stylesheet"
	rev="stylesheet" />
<!-- starter-template.js -->
<link href="css/main.css" type="text/css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

		<jsp:include page="navbar.jsp"></jsp:include>

		<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a href="javascript:;">Update Infornation</a></li>
        <li><a href="user_logout">Logout</a></li>
         <li><a href="cart_history">购物历史</a></li>
    </ul>
        <form class="form-horizontal" action="user_updateInformation" method="post">
        <fieldset>
           <fieldset>
            <legend>Update Password</legend>
            <div class="form-group">
                <label class="col-md-3 control-label">Old Password</label>
                <div class="col-md-5">
                    <input class="form-control" type="password" name="oldpassword" placeholder="Old Password">
                                    </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">New Password</label>
                <div class="col-md-5">
                    <input class="form-control" type="password" name="newpassword" placeholder="New Password">
                                    </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">Repeat New</label>
                <div class="col-md-5">
                    <input class="form-control" type="password" name="newpassword2" placeholder="Repeat New">
                                    </div>
            </div>
            <div class="col-md-offset-3 col-md-5 form-footer">
                <button type="submit" class="btn btn-primary" >Submit</button>
                <button type="reset" class="btn btn-primary">Reset</button>
            </div>
        </fieldset>
        
        </fieldset>
    </form>
</div>

</body>
</html>
