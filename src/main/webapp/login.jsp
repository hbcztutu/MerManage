<!DOCTYPE html>
<html lang="en" class="no-js">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <head>
        <meta charset="utf-8">
        <title>登录</title>
		<meta name="keywords" content="" />
		<meta name="description" content="登录首页" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="hbcztutu">

        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script >
function subform(){
	
	if(true/* validate() */){
		 document.getElementById("form").submit();
	}
};

</script>
    </head>

    <body onload="init()" >
22222222222222222222222222
        <div class="page-container">
            <h1 ><img alt="后台管理登录系统	" src="assets/img/admin_logo.png"></h1>
            <form id = "form" action="test2.do" method="post"  ">
                <input type="text" name="username" class="username" placeholder="用户名">
                <input type="password" name="password" class="password" placeholder="密码">
                <div class="checkcode">
  			    <input type="text"  id="J_codetext" style= "width:120px;float:left" placeholder="222222222222验证码"  maxlength="4" class="login_txtbx">
    			<canvas style= "inline:true;margin-top:30px;width:80px; " class="J_codeimg" id="myCanvas" onclick="createCode()">
    			对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  				</div>
                <input type="button" class="button" onclick="subform()" value="提交"></input>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect" style="color:white">
                <p>Any problem, connect with:QQ450445091</p>
                <p>
                   <!--  <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a> -->
                </p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/Particleground.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="assets/js/verificationNumbers.js"></script>
<script>
$(document).ready(function() {

   //验证码
  createCode(); 
  
});
function init(){
	
};




</script>
    </body>

</html>


