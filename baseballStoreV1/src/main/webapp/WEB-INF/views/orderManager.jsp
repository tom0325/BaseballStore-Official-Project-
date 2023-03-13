<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Manager</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<form action="order/add" method="post">
	Order ID: <input type="text" name="orderId" value="1"><br>
	Phone: <input type="text" name="phone" value="0912345678"><br>
	Total: <input type="text" name="total" value="9999"><br>
	<input type="text" name="status" value="N"><br>
	<button id="add">新增</button><br>
</form>
	<button id="query">查詢</button><br>
<div id="dis"></div>
<script>
var x = Documont.getElementByid();
if(x=1){
	
}
	function display(data) {
		$("#dis").html(data);
	}
	function query() {
		$.get("order/getAll", display);
	}
	function start() {
		$("#query").click(query);
		$("#add").click(add);
	}
	$(document).ready(start);
</script>
</body>
</html>