/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.14.v20181114
 * Generated at: 2019-04-19 13:23:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("file:/D:/software/m3/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1473048908000L));
    _jspx_dependants.put("jar:file:/D:/software/m3/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425949870000L));
    _jspx_dependants.put("jar:file:/D:/software/m3/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("file:/D:/software/m3/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1474541998000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>ego | 后台登陆</title>\r\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <!-- Bootstrap 3.3.4 -->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <!-- Theme style -->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/dist/css/AdminLTE.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <!-- iCheck -->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/plugins/iCheck/square/blue.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <style>#imgVerify {\r\n");
      out.write("        width: 120px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        display: block;\r\n");
      out.write("    }    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        function detectBrowser() {\r\n");
      out.write("            var browser = navigator.appName\r\n");
      out.write("            if (navigator.userAgent.indexOf(\"MSIE\") > 0) {\r\n");
      out.write("                var b_version = navigator.appVersion\r\n");
      out.write("                var version = b_version.split(\";\");\r\n");
      out.write("                var trim_Version = version[1].replace(/[ ]/g, \"\");\r\n");
      out.write("                if ((browser == \"Netscape\" || browser == \"Microsoft Internet Explorer\")) {\r\n");
      out.write("                    if (trim_Version == 'MSIE8.0' || trim_Version == 'MSIE7.0' || trim_Version == 'MSIE6.0') {\r\n");
      out.write("                        alert('请使用IE9.0版本以上进行访问');\r\n");
      out.write("                        return;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        detectBrowser();\r\n");
      out.write("    </script>\r\n");
      out.write("    <meta name=\"__hash__\" content=\"35a35d71936253d091570f5dcdf3efda_36195b7c33bcc5ab73f67451e5438f65\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login-page\">\r\n");
      out.write("<div class=\"login-box\">\r\n");
      out.write("    <div class=\"login-logo\">\r\n");
      out.write("        <a href=\"#\"><b>ego</b></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"login-box-body\">\r\n");
      out.write("        <p class=\"login-box-msg\">管理后台</p>\r\n");
      out.write("        <form>\r\n");
      out.write("        <div class=\"form-group has-feedback\">\r\n");
      out.write("            <input type=\"text\" name=\"userName\" id=\"userName\" class=\"form-control\" placeholder=\"账号\"/>\r\n");
      out.write("            <span class=\"glyphicon glyphicon-envelope form-control-feedback\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group has-feedback\">\r\n");
      out.write("            <input type=\"password\" name=\"password\" class=\"form-control\" id=\"password\" placeholder=\"密码\"/>\r\n");
      out.write("            <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group has-feedback\">\r\n");
      out.write("            <opinioncontrol realtime=\"true\" opinion_name=\"vertify_code\" default=\"true\">\r\n");
      out.write("                <div class=\"row\" style=\"padding-right: 65px;\">\r\n");
      out.write("                    <div class=\"col-xs-8\">\r\n");
      out.write("                        <input style=\"width: 135px\" type=\"text\" id=\"vertify\" name=\"vertify\" class=\"form-control\" placeholder=\"验证码\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-xs-4\">\r\n");
      out.write("                        <img id=\"imgVerify\" style=\"cursor:pointer;\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/getKaptchaImage\"\r\n");
      out.write("                             alt=\"点击更换\" title=\"点击更换\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </opinioncontrol>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <!--\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-xs-8\">\r\n");
      out.write("            <div class=\"checkbox icheck\">\r\n");
      out.write("              <label><input type=\"checkbox\"> 记住密码  </label>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-xs-4\">\r\n");
      out.write("            <div class=\"checkbox icheck\">\r\n");
      out.write("              <label><a href=\"#\">找回密码</a></label>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div> -->\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-block btn-flat\" onclick=\"login()\">立即登陆</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"margin text-center\">\r\n");
      out.write("        <div class=\"copyright\">\r\n");
      out.write("            2014-2016 &copy; <a href=\"http://www.ego.cn\">ego v1.3.3</a>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <a href=\"http://www.ego.cn\">北京506网络有限公司</a>出品\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div><!-- /.login-box -->\r\n");
      out.write("<!-- jQuery 2.1.4 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/plugins/jQuery/jQuery-2.1.4.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Bootstrap 3.3.2 JS -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- iCheck -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/plugins/iCheck/icheck.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Public/js/layer/layer.js\"></script><!-- 弹窗js 参考文档 http://layer.layui.com/-->\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $('input').iCheck({\r\n");
      out.write("            checkboxClass: 'icheckbox_square-blue',\r\n");
      out.write("            radioClass: 'iradio_square-blue',\r\n");
      out.write("            increaseArea: '20%' // optional\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    function fleshVerify() {\r\n");
      out.write("        //重载验证码\r\n");
      out.write("        $('#imgVerify').attr('src', '/index?m=Admin&c=Admin&a=vertify&r=' + Math.floor(Math.random() * 100));\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    jQuery.fn.center = function () {\r\n");
      out.write("        this.css(\"position\", \"absolute\");\r\n");
      out.write("        this.css(\"top\", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +\r\n");
      out.write("                $(window).scrollTop()) - 30 + \"px\");\r\n");
      out.write("        this.css(\"left\", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) +\r\n");
      out.write("                $(window).scrollLeft()) + \"px\");\r\n");
      out.write("        return this;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function checkLogin() {\r\n");
      out.write("        var username = $('#username').val();\r\n");
      out.write("        var password = $('#password').val();\r\n");
      out.write("        var vertify = $('input[name=\"vertify\"]').val();\r\n");
      out.write("        if (username == '' || password == '') {\r\n");
      out.write("            layer.alert('用户名或密码不能为空', {icon: 2}); //alert('用户名或密码不能为空');\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if (vertify == '') {\r\n");
      out.write("            layer.alert('验证码不能为空', {icon: 2});\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if (vertify.length != 4) {\r\n");
      out.write("            layer.alert('验证码错误', {icon: 2});\r\n");
      out.write("            //fleshVerify();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url: '/index?m=Admin&c=Admin&a=login&t=' + Math.random(),\r\n");
      out.write("            type: 'post',\r\n");
      out.write("            dataType: 'json',\r\n");
      out.write("            data: {username: username, password: password, vertify: vertify},\r\n");
      out.write("            success: function (res) {\r\n");
      out.write("                if (res.status == 1) {\r\n");
      out.write("                    top.location.href = res.url;\r\n");
      out.write("                } else {\r\n");
      out.write("                    layer.alert(res.msg, {icon: 2});\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            error: function (XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("                layer.alert('网络失败，请刷新页面后重试', {icon: 2});\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    document.onkeydown = function (event) {\r\n");
      out.write("        e = event ? event : (window.event ? window.event : null);\r\n");
      out.write("        if (e.keyCode == 13) {\r\n");
      out.write("            checkLogin();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function login(){\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/user/login',\r\n");
      out.write("            type: 'POST',\r\n");
      out.write("            dataType:'JSON',\r\n");
      out.write("            data: {\r\n");
      out.write("                userName:$(\"#userName\").val().trim(),\r\n");
      out.write("                password:$(\"#password\").val().trim(),\r\n");
      out.write("                vertify:$(\"#vertify\").val().trim()\r\n");
      out.write("            },\r\n");
      out.write("            success: function (result) {\r\n");
      out.write("                console.log(result);\r\n");
      out.write("                if (200==result.code) {\r\n");
      out.write("                    layer.msg(\"登录成功!\");\r\n");
      out.write("                    window.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index\";\r\n");
      out.write("                }\r\n");
      out.write("                if(503==result.code){\r\n");
      out.write("                    layer.msg(result.message);\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(504==result.code){\r\n");
      out.write("                    layer.msg(result.message);\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(400==result.code) {\r\n");
      out.write("                    layer.alert(result.message);\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            },\r\n");
      out.write("            error: function (result) {\r\n");
      out.write("                console.log(result);\r\n");
      out.write("                layer.alert(\"亲,系统正在升级中,请稍后再试!\");\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //点击更换图片\r\n");
      out.write("    $(\"#imgVerify\").on(\"click\",function () {\r\n");
      out.write("        $(\"#imgVerify\").attr(\"src\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/getKaptchaImage?time=\"+new Date());\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/pages/login.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("ctx");
      // /WEB-INF/pages/login.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/login.jsp(4,0) '${pageContext.request.contextPath }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}