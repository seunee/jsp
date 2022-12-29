<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My DOG</title>
<link rel="stylesheet" href="/resources/mydog.css">
</head>
<body>
	<c:choose>
   		<c:when test="${ses.email ne null && ses.email ne ''}">
   			 <header>
   			 	<div class="logoBox">
                    <!-- <img src="/img/heart_spinning.gif" alt=""> -->
                    <a href="/"><img src="/images/heart-gif-6.gif" alt=""></a>
                </div>
		        <ul class="head_ul login_ul">
		            <li class="head_li">
		                <a href="/brd/myList">MY BOARD</a>
		            </li>
		            <li class="head_li">
		                <a href="/mem/list">MEMBER</a>
		            </li>
		            <li class="head_li lastli">
		                <a href="/brd/pageList">GUESTBOOK</a>
		            </li>
		            <li class="head_li">
		                <a href="/mem/logout">LOGOUT</a>
		            </li>
		        </ul>
		    </header>
   		</c:when>
   		<c:otherwise>
		    <header>
		    	<div class="logoBox">
                    <!-- <img src="/img/heart_spinning.gif" alt=""> -->
                    <a href="/"><img src="/images/heart-gif-6.gif" alt=""></a>
                </div>
		        <ul class="head_ul">
		            <li class="head_li">
		                <a href="/mem/signin">SIGN IN</a>
		            </li>
		            <li class="head_li">
		                <a href="/mem/join">CREATE ACCOUNT</a>
		            </li>
		            <li class="head_li">
		                <a href="/mem/list">MEMBER</a>
		            </li>
		            <li class="head_li lastli">
		                <a href="/brd/pageList">GUESTBOOK</a>
		            </li>
		        </ul>
		    </header>
   		</c:otherwise>
   	</c:choose>
	<div class="title">
        <img src="/images/dog-face_1f436.png" alt=""><br>
        <span class="name">SeungNam Yoon</span><br>
        <span class="desc">He is 12 years old!</span><br>
        <span class="desc">He is so ADORABLE!</span><br>
    </div>
    <div id="slideShow">
        <ul class="slides">
            <li><img src="/images/오이승남.jpg" alt=""></li>
            <li><img src="/images/벚꽃승남2.jpg" alt=""></li>
            <li><img src="/images/우비승남_공원.jpg" alt=""></li>
            <li><img src="/images/턱받이승남_하트.jpg" alt=""></li>
            <li><img src="/images/무지개승남.jpg" alt=""></li>
            <li><img src="/images/우비승남_윙크.jpg" alt=""></li>
            <li><img src="/images/졸린승남_공원.jpg" alt=""></li>
            <li><img src="/images/목욕승남.jpg" alt=""></li>
        </ul>
        <p class="controller">
            <span class="prev"><i class="fa-solid fa-chevron-left fa-2xl"></i></span>
            <span class="next"><i class="fa-solid fa-chevron-right fa-2xl"></i></span>
        </p>

    </div>
    <script src="/resources/mydog.js"></script>
        
    <script src="https://code.iconify.design/iconify-icon/1.0.2/iconify-icon.min.js"></script>
    <script src="https://kit.fontawesome.com/0466d36352.js" crossorigin="anonymous"></script>
</body>
</html>