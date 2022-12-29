<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN IN</title>
<link rel="stylesheet" href="/resources/member_login.css?ver=4">
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
		                <a href="/brd/guest">GUESTBOOK</a>
		            </li>
		            <li class="head_li">
		                <a href="/mem/pageList">LOGOUT</a>
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
        <div class="head_title">
            CREATE ACCOUNT
        </div>
    </section>
    <div class="head_container">
        <span class="head_comment">
            Sign In if you have an ACCOUNT
        </span>
    </div>
        <form action="/mem/login" method="post">
            <table>
                <tr>
                    <td><input type="text" name="email" placeholder="EMAIL" class="neoRe"></td>
                </tr>
                <tr>
                    <td><input type="password" name="pwd" placeholder="PASSWORD" class="neoRe"></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="loginBtn">SIGN IN</button>
                    </td>
                </tr>
            </table>
        </form>
        <div class="bottomBox">
            <div class="btmContainer">
                <img src="/images/나_제안.png" alt="">
                <span class="head_comment">
                    If you don't have an account...
                </span>
            </div>
            <a href="/mem/join"><button class="regBtn">CREATE ACCOUNT</button></a>
        </div>
    <script type="text/javascript">
	const msg_login='<c:out value="${msg_login}" />';
	if(msg_login==='0'){
		alert("로그인에 실패했습니다.");
	}
	</script>
</body>
</html>