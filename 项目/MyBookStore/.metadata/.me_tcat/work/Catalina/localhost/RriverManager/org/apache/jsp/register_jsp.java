package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>注册</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base/stylebase.jsp", out, false);
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\trev=\"stylesheet\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checkData() {\r\n");
      out.write("\t\tif ($('#loginid').val() == \"\") {\r\n");
      out.write("\t\t\t$.messager.alert(\"提示信息\", \"请输入账号信息。\", \"info\");\r\n");
      out.write("\t\t} else if ($('#password').val() == \"\") {\r\n");
      out.write("\t\t\t$.messager.alert(\"提示信息\", \"请输入密码信息。\", \"info\");\r\n");
      out.write("\t\t} else if ($('#name').val() == \"\") {\r\n");
      out.write("\t\t\t$.messager.alert(\"提示信息\", \"请输入密码信息。\", \"info\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdoRegister();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//执行登录\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 返回的数据的格式为：{\"json\":{},\"user\":{}}\r\n");
      out.write("\t * @memberOf {TypeName} \r\n");
      out.write("\t * @return {TypeName} \r\n");
      out.write("\t */\r\n");
      out.write("\tfunction doRegister() {\r\n");
      out.write("\t\t$('#form').form('submit', {\r\n");
      out.write("\t\t\turl : 'user_register',\r\n");
      out.write("\t\t\tonSubmit : function() {\r\n");
      out.write("\t\t\t\treturn $(this).form('validate');\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\tif (result == null)\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\tresult = $.parseJSON(result); //转换为json对象\r\n");
      out.write("\t\t\t\t//result = $.parseJSON(result.json);   //取出json数据来再转换为json对象\r\n");
      out.write("\t\t\t\tvar msg = result.message;\r\n");
      out.write("\t\t\t\tif (result.success) {\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"信息提示\", msg, \"info\", function() {\r\n");
      out.write("\t\t\t\t\t\twindow.location.href = 'main.jsp';\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"错误\", \"操作失败！\" + msg, \"error\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"login\">\r\n");
      out.write("\t<div class=\"dl\">\r\n");
      out.write("\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t<img src=\"css/images/ico02.jpg\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form name=\"form\" id=\"form\" method=\"post\" action=\"user_register\"\r\n");
      out.write("\t\t\tautocomplete=\"off\">\r\n");
      out.write("\t\t\t<div class=\"log\">\r\n");
      out.write("\t\t\t\t<ul class=\"xuzhi02\">\r\n");
      out.write("\t\t\t\t\t<img src=\"images/earth.jpg\" />\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"deng02\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%; height:60px;\"><label>账号：</label> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"loginid\" name=\"user.loginid\" style=\"height: 35px;width: 300px\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-textbox\" required=\"true\" missingMessage=\"填写账号\" />\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<div style=\"clear:both;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%; height:40px;\"><label>姓名：</label> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"name\" name=\"user.name\" style=\"height: 35px;width: 300px\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-textbox\" required=\"true\" missingMessage=\"填写姓名\" />\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%; height:40px;\"><label>密码：</label> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"password\" name=\"user.password\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"height: 35px;width: 300px\" class=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\t\trequired=\"true\" missingMessage=\"填写密码\" />\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%; height:40px;\"><label>用户类型：</label> <input\r\n");
      out.write("\t\t\t\t\t\tname=\"user.state\" type=\"radio\" value=1 required=\"true\" /> web端<input\r\n");
      out.write("\t\t\t\t\t\tname=\"user.state\" type=\"radio\" value=2 required=\"true\" /> 手机端</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%;\">\r\n");
      out.write("\t\t\t\t\t\t<button id=\"logonbtn\" class=\"btn-login02\" onclick=\"checkData()\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"button\" style=\"margin-left: 110px;width: 200px\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册</span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
