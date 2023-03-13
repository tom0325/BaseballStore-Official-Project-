<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>Pitcher Item Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.101.0">

  <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/navbar-static/">
  <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/album/">
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
  <link href="css/navbar-top.css" rel="stylesheet">
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
  

  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script>window.jQuery || document.write('<script src="js/jquery.slim.min.js"><\/script>')</script><script src="js/bootstrap.bundle.min.js"></script>


<div class="album py-5 bg-light">
  <div class="container">

    <div class="row">
      <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
          <img src="images/pit01.jpg" id="mypic" class="bd-placeholder-img card-img-top" width="100%" height="255" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" title="打擊手套">
          <p class="card-header">
            ${data[0].description}
          </p>
            <h3 class="card-header">${data[0].productName}</h3>
<form action="addShopping" method="post" >
          <table border="0" style="font-size: 20px; margin:15px;" cellpadding="8">
            <tr>
              <td>
                <h3>${data[0].price}元</h3>
              </td>
              <td>
                現存${data[0].stock}個
              </td>
            </tr>
            <tr>
              <td>
              	<input type="hidden" name="pid" value="${data[0].productId}">
                數量&nbsp;<input type="number" name="amount" min="0" max="10" step="1" value="0">
              </td>
              <td>
                <input type="submit" class="btn btn-block btn-outline-primary" value="加入購物車">
              </td>
            </tr>
          </table>
</form>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
          <img src="images/pit02.jpeg" id="mypic" class="bd-placeholder-img card-img-top" width="100%" height="255" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" title="球棒">
          <p class="card-header">
            ${data[1].description}
          </p>
            <h3 class="card-header">${data[1].productName}</h3>
<form action="addShopping" method="post" >
          <table border="0" style="font-size: 20px; margin:15px;" cellpadding="8">
            <tr>
              <td>
                <h3>${data[1].price}元</h3>
              </td>
              <td>
                現存${data[1].stock}個
              </td>
            </tr>
            <tr>
              <td>
              	<input type="hidden" name="pid" value="${data[1].productId}">
                數量&nbsp;<input type="number" name="amount" min="0" max="10" step="1" value="0">
              </td>
              <td>
                <input type="submit" class="btn btn-block btn-outline-primary" value="加入購物車">
              </td>
            </tr>
          </table>
</form>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
          <img src="images/pit03.png" id="mypic" class="bd-placeholder-img card-img-top" width="100%" height="255" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" title="球">
          <p class="card-header">
            ${data[2].description}
          </p>
          <h3 class="card-header">${data[2].productName}</h3>
<form action="addShopping" method="post" >
          <table border="0" style="font-size: 20px; margin:15px;" cellpadding="8">
            <tr>
              <td>
                <h3>${data[2].price}元</h3>
              </td>
              <td>
                現存${data[2].stock}個
              </td>
            </tr>
            <tr>
              <td>
              	<input type="hidden" name="pid" value="${data[2].productId}">
                數量&nbsp;<input type="number" name="amount" min="0" max="10" step="1" value="0">
              </td>
              <td>
                <input type="submit" class="btn btn-block btn-outline-primary" value="加入購物車">
              </td>
            </tr>
          </table>
</form>


        </div>
      </div>
      
    </div>
  </div>
</div>
</body>
</html>