<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<jsp:include page="../layout/header.jsp"></jsp:include>
	<form action="/mem/signup" method="post">
		ID: <input type="text" name="id"> <br>
		PASSWORD: <input type="text" name="pw"> <br>
		NAME: <input type="text" name="name"> <br>
		AGE: <input type="text" name="age"> <br>
		EMAIL: <input type="text" name="email"> <br>
		ADDRESS: <input type="text" name="home"> <br>
		<button type="submit">SIGN UP</button>
	</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>
	<script type="text/javascript">
	const msg='<c:out value="${msg}"/>';
	if(msg==='0'){
		console.log(msg);
		alert("가입에 실패했습니다.");
	}
	</script>