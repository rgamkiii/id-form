<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Id Form</title>
<link rel="stylesheet" type="text/css" href="../styles/estilo.css">
<script src="../scripts/jquery.min.js"></script>
<script src="../scripts/log_out.js"></script>
<script src="../scripts/scripts-cita/guardar_cita.js"></script>
</head>
<body>
	<fieldset>
		<form action="../Id-FormServlet" method="post">
			Name:<br></br>
			<fieldset>
				<input type="text" name="firstName" value="" placeholder="fisrt name" required="required">
				<input type="text" name="lastName" value="" placeholder="last name" required="required">
			</fieldset>
			Date of birth:<br></br>
			<input type="date" name="birthDate" id="birthDate" required="required">
			Place of birth:<br></br>
			<fieldset>
				<input type="text" name="country" value="" placeholder="country" required="required">
				<input type="text" name="state" value="" placeholder="state" required="required">
				<input type="text" name="city" value="" placeholder="city" required="required">
			</fieldset>
			E-mail:<br></br>
			<fieldset>
				<input type="text" name="email" value="" placeholder="e-mail address" required="required">
			</fieldset>
			<input type="submit" value="Save data">
		</form>
		<%--This is a comment--%>
	</fieldset>
	<footer id="pageFooter">IBM Student Program Project</footer>
</body>
</html>
   