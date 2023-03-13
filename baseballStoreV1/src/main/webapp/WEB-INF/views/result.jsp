<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Result</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<table border="1" style="width: 70%">
      <tr>    
      	<th>Order ID</th>
      	<th>Phone</th>
      	<th>Total</th>
      	<th>Status</th>
      </tr>
      <c:forEach  var="o"  items="${orders}" >
      <tr>
        <td><c:out value="${o.orderId}" /></td>
        <td><c:out value="${o.phone}" /></td>
        <td><c:out value="${o.total}" /></td>
        <td><c:out value="${o.status}" /></td>
      </tr>
      </c:forEach>
</table>
</body>
</html>