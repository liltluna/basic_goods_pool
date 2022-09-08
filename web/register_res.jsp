<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<body>
	<p>
		<%
			HashMap<String, String> res = (HashMap<String, String>)request.getAttribute("infoList");
			out.println("<br>");
			out.println("username" + res.get("username"));
			out.println("password" + res.get("password"));
			// 改为数据库操作
			// 展示用户信息
		%>
	</p>

<form method="GET" action="Login.do">				
	<input type="SUBMIT" value="login">
</form>

</body>
</html>