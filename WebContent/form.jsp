<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register new Client</title>
</head>
<body>
<form  action="FrontController" method="post">
<fieldset>
<legend>Input Client Data</legend>
Id: <input type="text" name="id"><br>
Name <input type="text" name="name"><br>
<input type="hidden" name="cmd" value="registerClient">
<button>Submit</button>
</fieldset>
</form>
</body>
</html>