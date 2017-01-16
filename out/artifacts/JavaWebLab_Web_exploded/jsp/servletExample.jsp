<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body bgcolor="white">

<h1>
    I have been invoked by
    <% out.print(request.getAttribute("servletName").toString()); %>
    Servlet.
</h1>

</body>
</html>
