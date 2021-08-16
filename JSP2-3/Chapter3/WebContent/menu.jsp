<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp에서는 세션객체를 자동생성 -->
<%
String id =(String)session.getAttribute("id");
%>
<!-- 서블릿에서 로그인이 성공해서 세션영역에 id값이 저장되어 있다면 저장되어있는 id반환되어 ???님 환영합니다.출력 
id값이 저장되어 있지 않으면(즉, 로그인이 되어있지 않은 상태라면) null값이 반환되어
login.jsp로 이동 -->
</body>
<%
	if (id == null) {
%>
		<a href = "login.jsp">로그인</a>
<%
	} else {
%>
	<%=id %>님 환영합니다.
<%
	}
%>
</html>