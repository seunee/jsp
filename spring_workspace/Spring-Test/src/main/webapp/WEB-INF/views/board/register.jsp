<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../layout/header.jsp"></jsp:include>
	<form action="/brd/register" method="post" enctype="multipart/form-data">
		TITLE: <input type="text" name="title"> <br>
		WRITER: <input type="text" name="writer" value="${ses.id}" readonly="readonly"> <br>
		CONTENT: <textarea rows="3" cols="30" name="content"></textarea> <br>
		 <div class="col-12 d-grid">
  				<input class="form-control" type="file" style="display: none;"
  				 id="files" name="files" multiple>
  				<button type="button" id="trigger" class="btn btn-outline-primary btn-block d-block">Files Upload</button>
			</div>		
			<div class="col-12" id="fileZone">
			</div>
		
		
		<button type="submit" id="regBtn">등록</button>
	</form>
	<a href="/brd/list"><button>게시판</button></a>
	<a href="/"><button>HOME</button></a>
<script type="text/javascript" src="/resources/js/boardRegister.js"></script>
<jsp:include page="../layout/footer.jsp"></jsp:include>