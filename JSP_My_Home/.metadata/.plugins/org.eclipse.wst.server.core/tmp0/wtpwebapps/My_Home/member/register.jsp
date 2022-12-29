<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATE ACCOUNT</title>
<link rel="stylesheet" href="/resources/member_register.css">

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
	<section>
        <div class="head_title">
            CREATE ACCOUNT
        </div>
    </section>
    <div class="main">
        <div class="head_container">
            <img src="/images/나_메롱.png" alt="">
            <span class="head_comment">
                Sign Up if you want to write a post!
            </span>
        </div>
        <form action="/mem/register" method="post">
            <table>
                <tr>
                    <th>EMAIL</th>
                    <td><input type="text" name="email" class="neoRe"></td>
                </tr>
                <tr>
                    <th>PASSWORD</th>
                    <td><input type="text" name="pwd" class="neoRe"></td>
                </tr>
                <tr>
                    <th>NICKNAME</th>
                    <td><input type="text" name="nick_name" class="neoRe"></td>
                </tr>
            </table>
            <button type="submit">SUBMIT</button>
        </form>
    </div>
    
   <script type="text/javascript">
	const msg_reg='<c:out value="${msg_reg}" />';
	if(msg_reg==='0'){
		alert("이메일이 중복입니다.");
	}else if(msg_reg==='1'){
		alert("닉네임이 중복입니다.");
	}
	</script>
</body>
</html>