<html>
<script>
    function call() 
    {
        var name = "Gautam";
        window.location.replace("NewFile.jsp?name=" + name);
    }
</script>
<input type="button" value="Get" onclick='call()'>
<input type="text" name="addrBasic">
<%
    String name = request.getParameter("name");
    if (name != null) 
    {
        out.println(name);
    }
%>
</html>