<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
            margin:0;
        }
        .youtube{
            width:100%;
            height:600px;
        }

        h1{

/* text-align: center; */
/* background-color:blue; */
/* padding:20px; */
/* margin:15px; */
z-index:1;
opacity:0.8;
font-size:40px;
padding-bottom: 600px;
color:rgb(200, 255, 0);

position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%, -50%);

/* animation:colorchange 10s infinite alternate; */

}
.video-back{
    /* opacity:0.5; */
            position:absolute;
            top:0;
            left:0;
            width:100%;
            height:100%;
            z-index:0;
        }


    </style>
</head>
<body>
    <h1><a class="navbar-brand" href="/baseballStoreV1/home">~Home Page~</a></h1>
    
    <div class="video-back" >
        <iframe width="100%" height="100%" src="https://www.youtube.com/embed/PvBvkp-r4C4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen ></iframe>
    </div>

</body>
</html>