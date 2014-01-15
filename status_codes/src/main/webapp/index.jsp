<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
			<title>HTTP status codes</title>
	</head>

	<body>
		<table border="1">
			<tr>
				<td>
					<form name="form1" method="post" action="403Error">
						<input type="submit" name="submit" value="HTTP status codes 403">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form name="form2" method="post" action="404Error">
						<input type="submit" name="submit" value="HTTP status codes 404">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form name="form3" method="post" action="500Error">
						<input type="submit" name="submit" value="HTTP status codes 500">
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>