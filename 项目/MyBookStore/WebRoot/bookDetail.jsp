<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<TITLE>bookList</TITLE>
<%@ include file="base.jsp"%>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/main.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
function view_cart() {
	window.location.href = 'cart_show';
}

function do_submit() {
	var msg = "Are you sure you want to add to the shopping cart";
	if (confirm(msg) === true)
		submit();
}

function submit() {
	$.ajax({
		url : 'cart_submit',
		dataType : 'json',
		success : function(result) {
			if (result == null)
					return;
			alert(添加成功);
			result = $.parseJSON(result);
			var msg = result.message;
			if (result.success) {
				alert(msg);
			} else {
				alert(msg);
			}
		}
	})
}
</script>
</HEAD>
<BODY>
	<jsp:include page="navbar.jsp"></jsp:include>
	<CENTER>
		<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff
			background=img/top1bg.jpg border=0>
			<TBODY>
				<TR>
					<TD width=778>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE class=center height=100 cellSpacing=0 cellPadding=0 width=778
			bgColor=#ffffff border=0>
			<TBODY>
				<TR>
					<TD align=middle width=150><IMG title="" height=100
						src="img/logo.jpg" width=100 border=0>
					</TD>
					<TD width=58>&nbsp;</TD>
					<TD vAlign=top width=110><IMG height=90 src="img/top1.jpg"
						width=70 border=0>
					</TD>
					<TD vAlign=top width=110><IMG height=90 src="img/top2.jpg"
						width=70 border=0>
					</TD>
					<TD vAlign=top width=110><IMG height=90 src="img/top3.jpg"
						width=70 border=0>
					</TD>
					<TD vAlign=top width=110><IMG height=90 src="img/top4.jpg"
						width=70 border=0>
					</TD>
					<TD width=130></TD>
				</TR>
			</TBODY>
		</TABLE>

		<TABLE class=center cellSpacing=0 cellPadding=0 width=778
			bgColor=#ffffff border=0>
			<TBODY>
				<tr>
					<TD style="FONT-SIZE: 1px" bgColor=#b0b0b0 colSpan=19 height=1></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
			<TBODY>
				<TR>
					<TD style="FONT-SIZE: 1px" bgColor=#dcdcdc height=3></TD>
				</TR>
				<TR>
					<TD align=right background=img/bn01.jpg height=120>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>

		<TABLE height=15 cellSpacing=0 cellPadding=0 width=778 border=0>
			<TBODY>
				<TR>
					<TD style="FONT-SIZE: 10px; LINE-HEIGHT: 10px"
						background=img/bnbg1.gif height=15></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
			<TBODY>
				<TR>
					<TD vAlign=top width=168 height=200>
						<TABLE class=center height="100%" cellSpacing=0 cellPadding=0
							width=168 bgColor=#ffffff background=img/leftbg.gif border=0>
							<TBODY>

								<TR>
									<TD class=lefttd vAlign=top align=middle><BR></TD>
								</TR>
							</TBODY>
						</TABLE></TD>
					<TD vAlign=top align=middle width=610>
						<TABLE cellSpacing=0 cellPadding=0 width="98%"
							background=img/top01.gif border=0>
							<TBODY>
								<TR>
									<TD align=left height=25><IMG height=11
										src="img/icon1.gif" width=31> 图书详细信息页面</TD>
								</TR>
							</TBODY>
						</TABLE> <BR> <c:forEach items="${books}" var="book">

							<c:if test="${book.ASIN eq param.isbn}">
								<c:set value="${book}" var="booktoadd" scope="session" />


								<table width="609" border="0">
									<tr>
										<td colspan="3"><div align="center">
												<h3>${booktoadd.title }</h3>
											</div>
										</td>
									</tr>
									<tr>
										<td width="141" rowspan="5"><div align="center">
												<img src="img/${booktoadd.imageFile}" />
											</div>
										</td>
										<td width="197"><div align="left">图书编号：</div>
										</td>
										<td width="257"><div align="left">${booktoadd.ASIN}</div>
										</td>
									</tr>
									<tr>
										<td><div align="left">价格：</div>
										</td>
										<td><div align="left">${booktoadd.price}</div>
										</td>
									</tr>
									<tr>
										<td><div align="left">出版商：</div>
										</td>
										<td><div align="left">${booktoadd.publisher}</div>
										</td>
									</tr>
									<tr>

										<td height="24">
											<form method="post" action="cart_submit">
												<input type="button" value="放入购物车" onclick="do_submit()">
											</form></td>
										<td><div align="left">
												<input type="button" value="查看购物车" onclick="view_cart()">
											</div>
										</td>
									</tr>
								</table>
							</c:if>
						</c:forEach> <BR></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE class=center cellSpacing=0 cellPadding=0 width=778
			bgColor=#ffffff border=0>
			<TBODY>
				<TR>
					<TD align=middle background=img/bk.gif height=50></TD>
				</TR>
			</TBODY>
		</TABLE>

	</CENTER>
</BODY>
</HTML>
