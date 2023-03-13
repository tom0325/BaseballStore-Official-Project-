<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qproduct</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/product/">

    

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/product.css" rel="stylesheet">
</head>
<body>
<div class="container">
    
<table class="table table-hover">
    <thead>
     <tr class="table-success">    
      <th>productId</th>
      <th>productKindId</th>
      <th>productName</th>
      <th>description</th>
      <th>price</th>
      <th>stock</th>
      <th>enabled</th>
     </tr>
     </thead>
     <tbody>

        <c:forEach  var="current"  items="${data}" >
        <tr>
          <td><c:out value="${current.productId}" /></td>
          <td><c:out value="${current.productKindId}" /></td>
          <td><c:out value="${current.productName}" /></td>
          <td><c:out value="${current.description}" /></td>
          <td><c:out value="${current.price}" /></td>
          <td><c:out value="${current.stock}" /></td>
          <td>
          	<c:if test="${current.enabled == '1'}">
            	<input class="check" data-id="${current.productId}" type="checkbox" checked/> 啟用
            </c:if>
            <c:if test="${current.enabled == '0'}">
            	<input class="check" data-id="${current.productId}" type="checkbox" /> 關閉
            </c:if>
          </td>
        </tr>
      	</c:forEach>
      
      </tbody>
</table>
</div>



				
<div id="showtable"></div>  
<script>
	function rs(data){
		$("#showtable").html(data);
	}
	$(".check").click(function(){
		var enabled = $(this).prop("checked");
		var productId = $(this).attr("data-id");
		$.post("enableProduct", {"productId": productId, "enabled": enabled}, rs)
	});
</script>              
</body>
</html>