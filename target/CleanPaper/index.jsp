<%@ page import="java.util.List" %>
<%@ page import="jdbc.j.Jdbc" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CleanPaper</title>
</head>
<body>
<form method="post" action="ServletBublic">
    Press button <input type="submit"  value="Bublic" />
    <input type="text" name="Bublic" >
</form>
<%List<String> list =(List<String>) request.getSession().getAttribute("Bublic");
    if (list != null)
    for (String s: list) {
        %>
          <%=s%>
<%
    }
%>
</br>
<%for (String s: Jdbc.con()) {
%>
<%=s%>
<%
    }
%>

</body>
</html>