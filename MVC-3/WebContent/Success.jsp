<%@page import="com.Entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function deleteFunc() {
		alert("This is Delete Fucntion");
		document.mypage.action = "del";
		document.mypage.submit();
	}

	function EditFunk() {

		alert("THis is Edit function");
		document.mypage.action = "edit";
		document.mypage.submit();

	}
</script>
</head>
<body>
<h1>Success Page</h1>


<form name="mypage">

		<%
			List<User> user = (List<User>) request.getAttribute("msg");
		%>

		<table border="2" style="color: red">
			<thead>
				<tr>
					<th>Select</th>
					<th>Uid</th>
					<th>Uname</th>
					<th>upassword</th>
					<th>uaddress</th>
					<th>age</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
			</thead>

			<tbody>
				<tr>

					<%
						for (User usr : user) {
					%>

					<td><input type="radio" name="uid" value="<%=usr.getUid()%>"></td>
					<td><%=usr.getUid()%></td>
					<td><%=usr.getUname()%></td>
					<td><%=usr.getUpassword()%></td>
					<td><%=usr.getUaddress()%></td>
					<td><%=usr.getAge()%></td>
					<td><button value="submit" onclick="EditFunk()">Edit</button></td>
					<td><button value="submit" onclick="deleteFunc()">Delete</button></td>


				</tr>

				<%
					}
				%>

			</tbody>

		</table>
	</form>
</body>
</html>