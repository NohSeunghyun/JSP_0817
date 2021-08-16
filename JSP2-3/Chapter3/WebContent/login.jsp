<!-- 
브라우저를 종료하고 세션에서 나갈 때 까지는 계속해서 세션이 유지된다는 것을 알 수 있다.
이 세션의 기능을 이용해서 상태가 유지되어야 하는 프로그램
즉, 로그인프로그램, 장바구니 프로그램 등을 구현할 수 있다.
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "sessionLogin" method="post">
		아이디 : <input type="text" name="id"/>
		비밀번호 : <input type="password" name="passwd"/><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>