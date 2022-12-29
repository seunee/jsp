<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT INFO</title>
<link rel="stylesheet" href="/resources/member_modify.css">
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
            EDIT INFO
        </div>
        <div class="head_container">
            <img src="/images/나_전구.png" alt="">
            <span class="head_comment">
                Only password and nickname can be modified.
            </span>
        </div>
    </section>
    <form action="/mem/modify" method="post">
	    <table>
	        <tr>
	            <th>EMAIL</th>
	            <td><input type="text" name="email" value="${mvo.email}" readonly class="neoRe"></td>
	        </tr>
	        <tr>
	            <th>PASSWORD</th>
	            <td><input type="text" name="pwd" value="${mvo.pwd}" class="neoRe"></td>
	        </tr>
	        <tr>
	            <th>NICKNAME</th>
	            <td><input type="text" name="nick_name" value="${mvo.nick_name}" class="neoRe"></td>
	        </tr>
	        <tr>
	            <th>REGISTRATION DATE</th>
	            <td><input type="text" name="reg_at" value="${mvo.reg_at}" readonly class="neoRe"></td>
	        </tr>
	        <tr>
	            <th>LAST LOGIN</th>
	            <td><input type="text" name="last_login" value="${mvo.last_login}" readonly class="neoRe"></td>
	        </tr>
	    </table>
		<button type="submit" class="editBtn">EDIT</button>
		<a href="/mem/remove?email=${mvo.email }"><button type="button" class="delBtn">DELETE ACCOUNT</button></a>
    </form>
</body>
</html>