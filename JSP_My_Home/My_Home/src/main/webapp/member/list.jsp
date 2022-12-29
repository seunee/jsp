<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER</title>
<link rel="stylesheet" href="/resources/member_list.css">
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
	        Member List
	    </div>
	    <div class="head_container">
	        <img src="/images/나_뽀뽀.png" alt="">
	    </div>
	</section>
<table>
        <tr class="thTr">
            <th>EMAIL</th>
            <th>NICKNAME</th>
            <th>REGISTRATION DATE</th>
            <th>LAST LOGIN</th>
        </tr>
        <c:choose>
            <c:when test="${!empty list }">
                <c:forEach items="${list }" var="mvo">
                    <tr>
                        <c:choose>
                            <c:when test="${mvo.email eq ses.email }">
                                <td><a href="/mem/edit?email=${mvo.email }">${mvo.email }</a></td>
                            </c:when>
                            <c:otherwise>
                                <td>${mvo.email }</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${mvo.nick_name }</td>
                        <td>${mvo.reg_at }</td>
                        <td>${mvo.last_login }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4"  class="no_post">
                        멤버가 없어~
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
</table>
</body>
</html>