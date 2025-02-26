<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--    First Filter 기본 생성자 호출: 인스턴스 생성!!!--%>
<%--    FirstFilter의 init 호출--%>
    <h1>Filter</h1>
    <h3>필터의 라이프 사이클</h3>
<%--    ul>li>a--%>
    <ul>
        <li><a href="first/filter">Filter 사용하기</a></li>
<%--        FirstFilter의 doFilter 호출--%>
<%--        서블릿으로 get 요청 도착 확인!--%>
<%--        서블릿 다녀온 후--%>

    </ul>

    <%-- 구분선 --%>
    <hr>
    <h3>필터의 활용</h3>
    <form action="member/regist" method="post">
<%--        label{아이디: }--%>
        <label>아이디: </label>
        <input type="text" name="userId">
        <br>
        <label>비밀번호: </label>
        <input type="password" name="password">
        <br>
        <label>이름: </label>
        <input type="text" name="name">
        <br>
        <button type="submit">가입하기</button>
    </form>
</body>
</html>