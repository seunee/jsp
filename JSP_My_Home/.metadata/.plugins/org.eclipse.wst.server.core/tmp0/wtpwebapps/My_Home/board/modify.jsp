<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
<link rel="stylesheet" href="/resources/board_register.css">

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
            Guest Book
        </div>
        <div class="head_container">
            <img src="/images/나_뽀뽀.png" alt="">
            <span class="head_comment">
                Feel Free to Post Any Comments HERE❤️
            </span>
        </div>
    </section>
    <form action="/brd/modify" method="post" enctype="multipart/form-data">
	    <table>
	        <tr>
	            <th>No.</th>
	            <td><input type="text" name="bno" value="${bvo.bno}" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <th>Title</th>
	            <td><input type="text" name="title" value="${bvo.title}" class="neoRe"></td>
	        </tr>
	        <tr>
	            <th>Writer</th>
	            <td><input type="text" name="writer" value="${bvo.writer}" readonly="readonly" class="neoRe"></td>
	        </tr>
	        <tr>
	            <th>Content</th>
	            <td><textarea name="content" cols="30" rows="10" class="neoRe">${bvo.content}</textarea></td>
	        </tr>
	        <tr>
	            <th>Image</th>
	            <td><input type="file" name="new_file" accept="image/*">
	            <input type="hidden" name="image_file" value="${bvo.image_file }"></td>
	        </tr>
	    </table>
		<button type="submit">EDIT</button>
    </form>
</body>
</html>