<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
<link rel="stylesheet" href="/resources/board_detail.css">
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
    <table>
        <tr>
            <th>No.</th>
            <td>${bvo.bno}</td>
        </tr>
        <tr>
            <th>Date</th>
            <td>${bvo.regdate}</td>
        </tr>
        <tr>
            <th>View</th>
            <td>${bvo.read_count}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${bvo.title}</td>
        </tr>
        <tr>
            <th>Writer</th>
            <td>${bvo.writer}</td>
        </tr>
        <c:if test="${bvo.image_file ne '' && bvo.image_file ne null }">
	        <tr>
	            <th>Image</th>
	            <td><img alt="" src="/file_uploaded/${bvo.image_file }"></td>
	        </tr>
        </c:if>
        <tr>
            <th>Content</th>
            <td>${bvo.content}</td>
        </tr>
    </table>
	<div class="commentBox">
		<c:choose>
   			<c:when test="${ses.email ne null && ses.email ne ''}">
				<input type="text" id="cmtWriter" value="${ses.nick_name}" readonly><br>
				<div class="commentInner">
					<textarea id="cmtText" cols="30" rows="10" placeholder="ADD COMMENT"></textarea>
					<!-- <input type="text" id="cmtText" placeholder="ADD COMMENT"><br> -->
					<button type="button" id="cmtAddBtn">POST</button>
				</div>
			</c:when>
			<c:otherwise>
				<input type="text" id="cmtWriter" value="LOGIN PLEASE!" readonly><br>
				<div class="commentInner">
					<textarea id="cmtText" cols="30" rows="10" placeholder="LOGIN PLEASE!" disabled="disabled"></textarea>
					<!-- <input type="text" id="cmtText" placeholder="ADD COMMENT"><br> -->
					<a href="/mem/signin"><button type="button">SIGN IN</button></a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<table id="commentList">
<!-- 		<tr>
			<th>Nickname</th>
			<th>Comment</th>
			<th>Date</th>
			<th>Edit/Delete</th>
		</tr> -->
	</table>
    <div class="btnBox">
        <a href="/brd/guest"><button class="guest_Btn">Guest Book</button></a>
        <!-- <a href="/"><button>HOME</button></a> -->
        <a href="/brd/write"><button class="postBtn">POST</button></a>
        <c:if test="${ses.nick_name eq bvo.writer }">
        <a href="/brd/edit?bno=${bvo.bno }"><button class="edit_Btn">EDIT</button></a>
        <a href="/brd/delete?bno=${bvo.bno }"><button class="delete_Btn">DELETE</button></a>
        </c:if>
    </div>
    <script type="text/javascript">
    	const bnoVal='<c:out value="${bvo.bno}"/>';
    </script>
    <script src="/resources/board_detail.js"></script>
    <script type="text/javascript">
    	printCommentList(bnoVal);
    </script>
</body>
</html>