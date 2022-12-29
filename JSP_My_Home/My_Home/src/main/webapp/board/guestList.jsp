<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GUEST BOOK</title>
<link rel="stylesheet" href="/resources/board_guestbook.css">
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
		                <a href="/mem/pageList">MEMBER</a>
		            </li>
		            <li class="head_li lastli">
		                <a href="/brd/guest">GUESTBOOK</a>
		            </li>
		        </ul>
		    </header>
   		</c:otherwise>
   	</c:choose>
	<section>
        <div class="head_title">
            Guest Book
        </div>
        <div class="head_container">
            <img src="/images/나_뽀뽀.png" alt="">
            <span class="head_comment">
                Feel Free to Post Any Comments HERE❤️
            </span>
        </div>
    </section>
    <table>
	        <tr class="thTr">
	            <th>No.</th>
	            <th>Thumbnail</th>
	            <th>Title</th>
	            <th>Writer</th>
	            <th>Date</th>
	            <th>View</th>
	        </tr>
	        <c:choose>
		        <c:when test="${!empty list }">
			        <c:forEach items="${list }" var="bvo">
				        <tr>
				            <td>${bvo.bno }</td>
				            <td>
				            	<c:if test="${bvo.image_file ne '' && bvo.image_file ne null }">
				            		<img alt="" src="/file_uploaded/th_${bvo.image_file}">
				            	</c:if>
				            </td>
				            <td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
				            <td>${bvo.writer }</td>
				            <td>${bvo.regdate }</td>
				            <td>${bvo.read_count }</td>
				        </tr>
				    </c:forEach>
		        </c:when>
		        <c:otherwise>
		        	<tr>
			        	<td colspan="6"  class="no_post">
			        		글이 없어요!
			        	</td>
		        	</tr>
		        </c:otherwise>
	        </c:choose>
    </table>
    <div class="pagingBox">
    	<c:if test="${pgh.prev }">
    		<a href="/brd/page?pageNo=${pgh.startPage-1 }%qty=${pgh.pgvo.qty}"><i class="fa-solid fa-chevron-left"></i></a>
    	</c:if>
    	<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
    		<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}">${i }  </a>
    	</c:forEach>
    	<c:if test="${pgh.next }">
    		<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty}"><i class="fa-solid fa-chevron-right"></i></a>
    	</c:if>
    </div>
    <c:if test="${ses.email ne null && ses.email ne ''}">
    <div class="btnBox">
	    <a href="/brd/write"><button class="btn">POST</button></a>
<!-- 	    <a href="/"><button class="btn">HOME</button></a> -->
    </div>
    </c:if>
</body>
</html>