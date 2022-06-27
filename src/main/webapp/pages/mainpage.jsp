<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--  <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %> --%>
<%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
 <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
 <script src="<c:url value="/js/main.js"/>">
 
 
 </script>
 
 <!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script> -->
 <script type="text/javascript" src="https://code.jquery.com/jquery-1.7.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  >
<%-- <form:form action="calculate" method="POST" modelAttribute="command"> --%>

<%-- Total impact for user : <input type="text" readonly id="totalimpact" value='${impact}'><br> --%>
<%@ include file="header.jsp" %>  
Total impact for user : <input type="text" readonly id="totalimpact" ><br>
<select name="name" id="resourceid">

  <c:forEach  items="${resources}" var="resource" varStatus="loop">
    <option value="${loop.index}">
        ${resource}
    </option>
  </c:forEach> 
</select>

 <input type="submit" value="Add" id="add" onclick="addResource()"> 


<table id="tblData">
<%-- <tr><td><form:select path="name" id="resourceid">

<form:options items="${resources}"/>
</form:select></td> <td><input type="submit" value="Add" onclick="addResource()"></td></tr> --%>
    <thead>
    <tr>
        <td>Resource</td>
         <th>Quantity</th>
        <th>CO2E</th>
        <th>SO2E</th>
         
    </tr>
    </thead>
    <tbody>
    <c:forEach  items="${calculatedimpact}" var="impact" varStatus="loop">
     <tr>
        <td>
           ${impact.resource}
        </td>
        <td>
        <input type=text value='${impact.quantity}'/>
        </td>
        <td>
        ${impact.CO2e}
        </td>
        <td>
        ${impact.SO2e}
        </td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
<%-- <input type="submit" value="Calculate" id="calculate" onclick="calculate('${impact}','${useremail}')"> --%>
<input type="submit" value="Calculate" id="calculate" onclick="calculate('${useremail}')">

</body>
</html>