<%@ page contentType="text/html;charset=gbk" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<HTML>
<HEAD>
<TITLE>���ﳵ</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/main.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
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
				src="img/logo.jpg" width=100 border=0></TD>
			<TD width=58>&nbsp;</TD>
			<TD vAlign=top width=110><IMG height=90
				src="img/top1.jpg" width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90
				src="img/top2.jpg" width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90
				src="img/top3.jpg" width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90
				src="img/top4.jpg" width=70 border=0></TD>
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
				width=168 bgColor=#ffffff background=img/leftbg.gif
				border=0>
				<TBODY>

					<TR>
						<TD class=lefttd vAlign=top align=middle><BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
			<TD vAlign=top align=middle width=610>
			<TABLE cellSpacing=0 cellPadding=0 width="98%"
				background=img/top01.gif border=0>
				<TBODY>
					<TR>
						<TD align=left height=25><IMG height=11
							src="img/icon1.gif" width=31> ���ﳵ�б�ҳ��</TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>

			<form method="POST" name="Regsiter" action="register">
			<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
				width=590 border=0>
				<TBODY>
					<!--   ��ʾ��ʼ  -->
						<form method="POST" name="Regsiter" action="register">
			  <table width="605" border="2">
                <tr>
                  <td><div align="center">����</div></td>
                  <td><div align="center">�۸�</div></td>
                  <td><div align="center">����</div></td>
                  <td><div align="center">�ܼ�</div></td>
                   <td><div align="center"><a href = "cart_deleteAll">���</a></div></td>
                </tr>
                <c:set var="totalMoney" value="0" scope="session"></c:set>                 
                <c:set var="cart1" value="${sessionScope.cartes}" scope="session"/>
                <c:choose>                
                <c:when test="${empty cartes}">
                  ${"���ﳵΪ��"}
                 <a href='index.jsp'>ǰȥ����</a>
                </c:when>
                <c:otherwise>
                
                <c:forEach items="${cart1}"  var="cart" varStatus="count">
                		<c:forEach items="${books}" var="book">
                		<c:if test="${cart.book_id eq book.id}">              
						<c:set value="${book}" var="sbook" scope="session" />
						</c:if></c:forEach>
                
                <c:set var="title" value="${sbook.title}"/>
                <c:set var="price" value="${sbook.price}"/>
                <c:set var="quatity" value="${cart.number}"/>
                <c:set var="totalPrice" value="${quatity * price }"/>
                <c:set value="${totalMoney+totalPrice}" var="totalMoney" scope="session"></c:set>           
                 <tr>
                  <td><div align="center">${title}</div></td>
                  <td><div align="center">${price}</div></td>
                  <td><div align="center">${quatity}</div></td>
                 <td><div align="center">${totalPrice}</div></td>
                  <td><div align="center"><a href = "cart_deleteCart?delete_id =${cart.id} ">ȡ��</a></div></td>
                </tr>             
                	
                </c:forEach>
                </c:otherwise>
                </c:choose>
                <tr>
                  <td colspan="3"><div align="right">�ϼ�</div></td>
                  <td>${totalMoney}</td>
                </tr>
              </table>
              <a href="index.jsp">��������</a><br/>
        
              <a href="processOrder.jsp">�ύ����</a>
			</form>
				</TBODY>
			</TABLE>
			</form>
			<BR>
			</TD>
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
