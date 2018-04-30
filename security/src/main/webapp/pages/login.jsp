<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/social-buttons.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/common.css" />
</head>
<body>
	<main id="login" class="container"> <header class="page-header">
		<h4>Login To UCApps Forum( Will think up a cool name later:) )</h4>
	</header>
	<div>
		<form role="form" action="spring_sec_auth.htm" method="post">
			<div class="form-group">
				<label for="name">UserName</label> <input type="text"
					class="form-control" style="width: 30%" name="username" />
			</div>
			<div class="form-group">
				<label for="pwd">Password</label> <input type="password"
					class="form-control" style="width: 30%" name="password" />
			</div>
			<div class="btn-toolbar">
				<button type="submit" class="btn btn-primary">Login</button>
				<button type="submit" class="btn btn-primary">Forgot Password</button>
			</div>
		</form>
		<form role="form" action="linkedin" method="post">
			<div class="form-group form-space">
				<button type="submit" class="btn btn-linkedin">Login with
					LinkedIn</button>
			</div>
		</form>
		<form role="form" action="facebook" method="post">
			<div class="form-group form-space">
				<button type="submit" class="btn btn-facebook">Login with
					FaceBook</button>
			</div>
		</form>
	</div>
	</main>
</body>
</html>