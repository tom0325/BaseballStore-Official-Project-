<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>The Shopping Cart Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.101.0">

  <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/navbar-static/">
  <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/album/">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script>window.jQuery || document.write('<script src="js/jquery.slim.min.js"><\/script>')</script><script src="js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

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
  <link href="navbar-top.css" rel="stylesheet">
</head>
<body>

  <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4 sticky-top">
    <a class="navbar-brand" href="/baseballStoreV1/home">首頁</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link disabled"></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/baseballStoreV1/offense">打擊<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/baseballStoreV1/defense">守備<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/baseballStoreV1/pitcher">投手<span class="sr-only">(current)</span></a>
        </li>
      </ul>
      
      <ul class="navbar-nav mt-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/baseballStoreV1/update">${sessionScope.name}<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <c:if test="${sessionScope.name == null}">
            	<a class="nav-link" href="/baseballStoreV1/signin">登入/註冊<span class="sr-only">(current)</span></a>	
            </c:if>
            <c:if test="${sessionScope.name != null}">
                <a class="nav-link" href="/baseballStoreV1/signin">登出<span class="sr-only">(current)</span></a>	    		
            </c:if>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled"></a>
        </li>
      </ul>

      <form class="form-inline mt-2 mt-md-0">
        <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='/baseballStoreV1/shoppingcart'">購物車</button>
      </form>
    </div>
  </nav>
  
  
  
  
  
  


  <div class="container">
    <h2>${sessionScope.name}</h2>
    <p>您的購物清單</p>            
    <table class="table table-hover">
      <thead>
        <tr class="table-success">
          <th>品項</th>
          <th>數量</th>
          <th>單價</th>
          <th>總價</th>
          <th width="100px"></th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="c" items="${cart}">
        <tr>
          <td>${c.name}</td>
          <td>${c.amount}</td>
          <td>${c.price}</td>
          <td>${c.total}</td>
          <td>
            <button class="deleteBtn" data-id="${c.id}" type="button">刪除</button>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>

  <p style="margin-top:50px;">
    <div class="row">
      <div class="col-lg-5"></div>
      <button type="button" onclick="location.href='addOrder'" class="col-lg-1 btn btn-danger" >確認購買</button>
    </div>
  </p>
  <script>
	$(".deleteBtn").click(function(e) {
		e.preventDefault();
		const id = $(this).attr("data-id");
		$.ajax({
			url: "delShopping",
			type: "POST",
			data: {"cartId": id},
			success: function() {
				
				console.log("test");
			},
				error: function() {
					console.log("error");}
				});
		window.location.reload();
		});
  </script>
</body>
</html>