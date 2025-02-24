<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

    <h1>Service Method</h1>
    <h3>GET 방식의 요청</h3>
    <h4>a태그의 href 속성값 변경</h4>
    <a href="request-service">GET 방식 서비스 요청하기</a>

    <h4>form 태그의 method 속성값 변경</h4>
    <%--request-service 라는 이름의 servlet으로 갈 것이다.
        어디로 "request-service" 서블릿으로
        어떻게 get
        submit 버튼
    --%>
    <form action="request-service" method="get">
<%--        <input type="submit" value="조회" />--%>
        <button type="submit">조회 버튼</button>
    </form>


    <h3>POST 방식의 요청</h3>
    <h4>form 태그의 method 속성을 post로 설정</h4>
    <form action="request-service" method="post">
        <button>POST 방식 요청 버튼</button>
    </form>
</body>
</html>