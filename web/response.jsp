<?xml version="1.0" encoding="ISO-8859-1"?>
<%@ page contentType="text/xml;charset=ISO-8859-1" %>
<wordresponse>
    <word>
        <%=request.getAttribute("word")%>
    </word>
<wordDefinition><%=request.getAttribute("wordDefinition")%>
 </wordDefinition>
</wordresponse>