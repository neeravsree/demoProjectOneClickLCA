<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.16.0/dist/jquery.validate.js"></script>
<script src="<c:url value="/js/validation.js"/>"> </script>
</head>
<body>
<form id="loginform" action="login" method="post">
Username:  <input type="text" name="username"/><br/><br/> 
Password: <input type="password" name="password"/><br/><br/> 
Email: <input type="text" name="email"/><br/><br/>
<input type="submit" value="login"/>

 </form>

</body>
</html>