<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<body>
	<p>
		<%
			HashMap<String, String> res = (HashMap<String, String>)request.getAttribute("infoList");
			if(res.get("username").equals("test")&&res.get("password").equals("123")){
				response.sendRedirect("Shop.do");
			}
			else{
				response.sendRedirect("login.html");
			}
		%>
	</p>
</body>
</html>