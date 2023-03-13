<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>The Homepage</title>
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
          <a class="nav-link" href="/baseballStoreV1/update" >${sessionScope.name}<span class="sr-only">(current)</span></a>
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
  
<p align="center" style="margin: 20px;">
<img src="images/oneball.png" id="mypic" width="650" height="120" />
</p>

<p align="center" style="margin: 50px auto;">
  <img src="images/kano.jpg" id="mypic" width="1000" height="600" />
</p>

<p>
  <hr style="border:3px solid #987cb9;" class="container"/>
</p>


<section class="jumbotron container">
  <div class="container" style="font-size: 20px;">
    <h2 style="color:rgb(141, 76, 7) ;">企業理念</h2>
    <p class="lead text-muted">
      <p>
        我們是由一群喜愛棒球、熱愛棒球、沒有棒球就吃不下飯、睡不著覺，甚至活不下去的棒球痴、棒球狂，所共同成立。
      </p>
      <p>
        秉持著愛心、服務、責任、紀律，與重視團隊合作之精神，打造高品質產品與服務給所有熱愛棒球的球迷、球員、企業等等，就如同公司的名稱 "一球入魂"，用生命帶給每一位顧客最高的使用體驗。
      </p>
      <p>
        工作之餘，我們更著力於社會公益、慈善捐款，我們於2022年11月發起一項運動，只要"你想打球，我出裝備"，幫助全台各地偏鄉中小學的小球員們，免費提供優良的裝備給予使用。
      </p>
      <p>
        此外，為實現環境永續經營理念，我們更是全面更換成友善環境的環保紙箱，樹立綠色電商典範，有利於企業永續發展，邁入電商減碳新時代。
      </p>
      <p>
        未來，我們將必"不忘初衷"，保持不變的經營理念，持續為社會大眾盡心盡力，給予最高品質的服務!
      </p>
    </p>
  </div>
</section>

<p>
  <hr style="border:1px solid #987cb9;" class="container"/>
</p>

<div class="album py-5 bg-light">
  <div class="container">

    <div class="row">
      <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
          <img src="images/off.png" id="mypic" class="bd-placeholder-img card-img-top" width="100%" height="100%" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" title="打擊">

          <div class="card-body">
            <p class="card-text">打擊</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/baseballStoreV1/offense'">GO</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
          <img src="images/def06.jpg" id="mypic" class="bd-placeholder-img card-img-top" width="100%" height="100%" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" title="守備">

          <div class="card-body">
            <p class="card-text">守備</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/baseballStoreV1/defense'">GO</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
          <img src="images/pit02.jpeg" id="mypic" class="bd-placeholder-img card-img-top" width="100%" height="100%" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" title="投手">

          <div class="card-body">
            <p class="card-text">投手</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/baseballStoreV1/pitcher'">GO</button>
              </div>
            </div>
          </div>
        </div>
      </div>

      
    </div>
  </div>
</div>
	<script>
            document.onkeydown = function (event)
            {
                if (event.keyCode === 81 && event.ctrlKey)
                {
                    var password=123456;
                    var input;
                    var entry_count=0;
                    var entry_limit=3;
                    var out_of_limit=false;

                    while(password!=input && !out_of_limit){
                        entry_count++;
                        if(entry_count<=entry_limit){
                            input=prompt("請輸入隱藏密碼");
                        }
                        else{
                            out_of_limit=true;
                        }
                    }

                    if(out_of_limit){
                        alert("超出輸入次數");
                    }
                    else{
                        alert("登入成功");
                        location.href="Admin";
                    }
                }
            };
        </script>
</body>
</html>