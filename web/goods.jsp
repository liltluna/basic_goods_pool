<%@ page import="java.util.ArrayList"%> 
<%@ page import="com.example.model.GGoods" %>
<!DOCTYPE html>
<html>
<body>

	<form method="GET" action="Login.do">				
		<input type="SUBMIT" value="login">
	</form>
	
	<form method="GET" action="Register.do">				
		<input type="SUBMIT" value="register">
	</form>
	
	<form method="GET" action="Shop.do">				
		<input type="SUBMIT" value="just look">
	</form>
	
	<p>
		<%
			ArrayList<GGoods> res = (ArrayList<GGoods>)request.getAttribute("goods");
			for(GGoods good : res){
                out.println("<hr>");
                out.println("id = " + good.getGoods_id() + "<br>");
                out.println("name = " + good.getGoods_name() + "<br>");
                out.println("price = " + good.getGoods_price() + "<br>");
                out.println("des = " + good.getGoods_description() + "<br>");

            }
		%>
	</p>

</body>
</html>