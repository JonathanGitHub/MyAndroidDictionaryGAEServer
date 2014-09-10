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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>online Dictionary</title>
    </head>
    <body>
        <p>Welcome to the online Dictionary, what keyword are you looking for?</p>
        <form action="MyAndroidDictionaryGAEServlet" method="GET">
            <label for="letter">Type the word.</label>
            <input type="text" name="search" value="" /><br>
            <input type="submit" value="Submit" />
            <label for ="letter"></label>
            
        </form>
    </body>
</html>
