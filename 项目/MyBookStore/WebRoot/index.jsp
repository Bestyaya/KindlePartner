<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="cn.gov.entity.User"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.gov.entity.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>主页</title>
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
<link href="js/starter-template.js" type="text/css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- 引入导航栏  -->
	<jsp:include page="navbar.jsp" flush="true"></jsp:include>

	<div class="container">
		<CENTER>
			<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff
				background=/myebookjstl/images/top1bg.jpg border=0>
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
							src="/myebookjstl/images/logo.jpg" width=100 border=0>
						</TD>
						<TD width=58>&nbsp;</TD>
						<TD vAlign=top width=110><IMG height=90
							src="/myebookjstl/images/top1.jpg" width=70 border=0>
						</TD>
						<TD vAlign=top width=110><IMG height=90
							src="/myebookjstl/images/top2.jpg" width=70 border=0>
						</TD>
						<TD vAlign=top width=110><IMG height=90
							src="/myebookjstl/images/top3.jpg" width=70 border=0>
						</TD>
						<TD vAlign=top width=110><IMG height=90
							src="/myebookjstl/images/top4.jpg" width=70 border=0>
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
						<TD align=right background=/myebookjstl/images/bn01.jpg height=120>&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE height=15 cellSpacing=0 cellPadding=0 width=778 border=0>
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 10px; LINE-HEIGHT: 10px"
							background=/myebookjstl/images/bnbg1.gif height=15></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD vAlign=top width=168 height=200>
							<TABLE class=center height="100%" cellSpacing=0 cellPadding=0
								width=168 bgColor=#ffffff
								background=/myebookjstl/images/leftbg.gif border=0>
								<TBODY>

									<TR>
										<TD class=lefttd vAlign=top align=middle><BR></TD>
									</TR>
								</TBODY>
							</TABLE></TD>
						<TD vAlign=top align=middle width=610>
							<TABLE cellSpacing=0 cellPadding=0 width="98%"
								background=/myebookjstl/images/top01.gif border=0>
								<TBODY>
									<TR>
										<TD align=left height=25><IMG height=11
											src="/myebookjstl/images/icon1.gif" width=31> 图书列表页面</TD>
									</TR>
								</TBODY>
							</TABLE> <BR>

							<form method="POST" name="Regsiter" action="register">
								<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
									width=590 border=0>
									<TBODY>
										<!--   显示开始  -->
										<jsp:useBean id="bookDao"
											class="com.lcx.book.dao.impl.BookDaoImpl" />
										<c:set var="list" value="${bookDao.allBooks}" scope="session" />
										<c:forEach items="${sessionScope.list}" var="book"
											varStatus="s">
											<c:if test="${s.index%3==0}">
												<tr>
											</c:if>
											<td>

												<table width="180" cellpadding="0" cellspacing="0" border=0>
													<tr>
														<td vAlign=bottom><a
															href="bookDetail.jsp?isbn=${book.ISBN }">${book.ISBN
																}</a></td>
													</tr>
													<tr>
														<td><c:choose>
																<c:when test="${fn:length(book.title)>20}">
					           ${fn:substring(book.title,1,17)}...
					         </c:when>
																<c:otherwise>
					           ${book.title }
					         </c:otherwise>
															</c:choose></td>
													</tr>
													<tr>
														<td><img src="/myebookjstl/images/${book.imageFile }">
														</td>
													</tr>
												</table></td>
											<c:if test="${s.index%3==2}">
												</tr>
											</c:if>
										</c:forEach>

										<!--   显示结束 -->
									</TBODY>
								</TABLE>
							</form> <BR></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class=center cellSpacing=0 cellPadding=0 width=778
				bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD align=middle background=/myebookjstl/images/bk.gif height=50></TD>
					</TR>
				</TBODY>
			</TABLE>

		</CENTER>
	</div>
</body>
</html>
