<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEUNGHEE's HOME</title>
<link rel="stylesheet" href="/resources/index_style.css?ver=2">
</head>
<body>
	<c:choose>
   		<c:when test="${ses.email ne null && ses.email ne ''}">
   			 <header>
   			 	<div class="logoBox">
                    <!-- <img src="/img/heart_spinning.gif" alt=""> -->
                    <a href="/"  title="Home"><img src="/images/heart-gif-6.gif" alt=""></a>
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
    <section>
     <div class="container">
		<img class="main_img" alt="사진 없음!" src="/images/나_코딩.png">
     </div>
     <div class="intro">
     	<span class="intro_span">
     	Hello
     	<c:choose>
     		<c:when test="${ses.email ne null && ses.email ne ''}">
     			${ses.nick_name } 👋
     		</c:when>
     		<c:otherwise>
     			There 👋
     		</c:otherwise>
     	</c:choose>
     	 <br>	
     	I am SeungHee !
     	</span>
     </div>
     <div class="lineBox">
        <div class="iBox">
            <a href="mailto:tmsl1912@naver.com"><i class="fa-solid fa-envelope fa-2x"></i></a>
            <a href="https://www.instagram.com/seunee/"><i class="fa-brands fa-instagram fa-2x"></i></a>
            <a href="tel:010-9430-1912"><i class="fa-solid fa-phone fa-2x"></i></a>

        </div>
     </div>
    </section>
     <main>
         <p class="mainComment">ALL ABOUT ME</p>
        <div class="mainBox">
            <div class="mainInner first">
                <img src="/images/나_메롱.png" alt="">
                <div class="innerDesc">
                    <div class="desc">
                        <span class="nameSpan">SeungHee Yoon</span><br>
                    </div>
                    <div class="desc">
                        <i class="fa-solid fa-location-dot"></i> <span class="firstSpan">Incheon, Korea</span> <br>
                    </div>
                    <div class="desc">
                        <i class="fa-solid fa-mobile-screen-button"></i> <span class="firstSpan">010-9430-1912</span> <br>
                    </div>
                    <div class="desc">
                        <i class="fa-regular fa-envelope"></i> <span class="firstSpan">tmsl1912@naver.com</span><br>
                    </div>
                    <div class="desc">
                        <iconify-icon inline icon="simple-icons:notion"></iconify-icon> <a href="https://url.kr/g5h9wo"><span class="firstSpan">https://url.kr/g5h9wo</span></a><br>
                    </div>
                    <div class="desc"></div>
                </div>
            </div>
            <div class="mainInner second">
                <img src="/images/나_하트많음.png" alt="">
                <p>What I LOVE</p>
                <div class="innerDesc">
                    <div class="desc">
                        <i class="fa-solid fa-paw"></i> <span class="firstSpan">Animal</span><br>
                        <p>(especially, <a href="/board/mydog.jsp">My DOG</a>!)</p>
                    </div>
                    <div class="desc">
                        <i class="fa-solid fa-pepper-hot"></i> <span class="firstSpan">Spicy Food</span><br>
                    </div>
                    <div class="desc">
                        <i class="fa-solid fa-headphones"></i> <span class="firstSpan">Music</span><br>
                    </div>
                    <div class="desc">
                        <i class="fa-solid fa-gamepad"></i> <span class="firstSpan">Game</span><br>
                    </div>
                </div>
            </div>
        <div class="mainInner third">
            <img src="/images/나_전구.png" alt="">
            <p>Capability</p>
            <div class="progressBox">
                <span>JAVA</span>
                <div class="progressBar">
                    <progress value="68" min="0" max="100"></progress>
                    <span class="progPercent">68%</span>
                </div>
            </div>
            <div class="progressBox">
                <span>JavaScript</span>
                <div class="progressBar">
                    <progress value="60" min="0" max="100"></progress>
                    <span class="progPercent">60%</span>
                </div>
            </div>
            <div class="progressBox">
                <span>MYSQL</span>
                <div class="progressBar">
                    <progress value="50" min="0" max="100"></progress>
                    <span class="progPercent">50%</span>
                </div>
            </div>
        </div>
        </div>
    </main>
     <script src="https://code.iconify.design/iconify-icon/1.0.2/iconify-icon.min.js"></script>
     <script src="https://kit.fontawesome.com/0466d36352.js" crossorigin="anonymous"></script>

</body>
</html>