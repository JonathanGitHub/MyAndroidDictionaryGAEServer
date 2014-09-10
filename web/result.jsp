<%-- 
    Document   : index
    Created on : 2013-2-1, 14:36:12
    Author     : Administrator
--%>


    <%
      String ua = request.getHeader("User-Agent");
         boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ua.indexOf("Android") != -1) {
            mobile = true;
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.0//EN\" \"http://www.wapforum.org/DTD/xhtml-mobile10.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
        //response.setContentType("text/html;charset=UTF-8");
     %>
     <%@page contentType="text/html" pageEncoding="UTF-8"%>
     <%= request.getAttribute("doctype") %>


<html>
    <head>
        <title>online Dictionary</title>
    </head>
    <body>
        <h1>Here is the definition of for <%= request.getAttribute("word")%></h1><br>
         <H2><FONT color=#bb0000 face="trebuchet ms"><%=request.getAttribute("wordDefinition")%> <BR></H2><FONT 
              color=#bb0000 face=cambria>
    </body>
</html>


