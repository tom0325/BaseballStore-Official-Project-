<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>The Administrator Page 1</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    
	<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/product/">
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/product.css" rel="stylesheet">

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


  </head>
<body>


   
      <script>window.jQuery || document.write('<script src="js/jquery.slim.min.js"><\/script>')</script><script src="js/bootstrap.bundle.min.js"></script>

<p style="margin: 50px auto;">


        
        
        
        <div class="container">
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" id="membersss">
            <button class="btn btn-primary my-2 my-sm-0" type="button" id="searchmembers" value="查詢">查詢</button>
          </form>
        </div>
        <p>


<div id="showtable"></div>

<script>

function rs(data){
	$("#showtable").html(data);
}

function send(evt){
	evt.preventDefault();
	var n=$("#membersss").val();
	$.get("getPhone",{"memberPhone":n},rs);
	return false;
}

function show(){
	$.get("getAllMember",rs);
}

function start(){
	$("#searchmembers").click(send);
	show();
}

$(document).ready(start);

</script>
</body>
</html>