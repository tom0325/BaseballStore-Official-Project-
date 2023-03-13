<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qorder</title>
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
                <thead align="center">
                  <tr class="table-success">    
                  <th>orderId</th>
                  <th>phone</th>
                  <th>total</th>
                  <th width="200px">status</th>
                  </tr>
                </thead>
                <tbody align="center">
                <c:forEach  var="current"  items="${data}" >
                  <tr>
                    <td>${current.orderId}</td>
                    <td><c:out value="${current.phone}" /></td>
                    <td><c:out value="${current.total}" /></td>
                    <td>
                     	<c:if test="${current.status == 'Y'}">
                    		<input class="check" data-id="${current.orderId}" type="checkbox" checked/> 已出貨
                    		&emsp;<button class="deleteBtn" type="button" data-id="${current.orderId}">刪除</button>
                    	</c:if>
                    	<c:if test="${current.status == 'N'}">
                    		<input class="check" data-id="${current.orderId}" type="checkbox" /> 未出貨
                    		&emsp;<button class="deleteBtn" type="button" data-id="${current.orderId}">刪除</button>
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

	$(".deleteBtn").click(function(e){
		const id = $(this).attr("data-id");
		$.post("delOrder", {"orderId": id}, rs)
	});
	$(".check").click(function(){
		var status = $(this).prop("checked");
		var orderId = $(this).attr("data-id");
		$.post("enableOrder", {"orderId": orderId, "status": status}, rs)
	});
</script>                
</body>
</html>