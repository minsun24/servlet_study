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
<h1>Request Parameter</h1>
<h3>GET 방식의 요청</h3>
<%--GET 요청으로 보낸 값들은 Request Header 에 담기게 된다.--%>
<h4>form 태그를 활용한 get 방식 요청</h4>
<form action="querystring" method="get">
    <label>이름: </label><input type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <%--  date형은 달력 형식으로 날짜 선택 가능  --%>
    <label>생일: </label><input type="date" name="birthday">
    <label>성별: </label>
        <input type="radio" name="gender" id="male" value="M">
        <label for="male">남자</label>

        <input type="radio" name="gender" id="female" value="F">
        <label for="female">여자</label>
    <br>
    <%-- 라디오박스 (다중 선택 불가능, 택 1) --%>
    <label>국적: </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <%-- 체크박스 (다중 선택 가능) --%>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label>영화보기 </label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label>음악 감상 </label>
    <input type="checkbox" name="hobbies" id="drawing" value="drawing"><label>그림 그리기 </label>
    <br>
    <button type="submit">GET 요청</button>
    
</form>

<br>
<h4>a 태그와 href 속성에 직접 파라미터를 써서 쿼리스트링을 작성하고 get요청을 할 수 있다. </h4>
<a href="querystring?name=정민선&age=23&birthday=2002-02-04&gender=F&national=ko&hobbies=movie&hobbies=music&hobbies=drawing">
    a 태그를 활용한 쿼리 스트링 방식
</a>

<br>
<hr>

<h3>POST 방식의 요청</h3>
<%--POST 요청으로 보낸 값들은 Request Body 에 담기게 된다.--%>
<form action="formdata" method="post">
    <label>이름: </label><input type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <%--  date형은 달력 형식으로 날짜 선택 가능  --%>
    <label>생일: </label><input type="date" name="birthday">
    <label>성별: </label>
    <input type="radio" name="gender" id="male" value="M">
    <label for="male">남자</label>

    <input type="radio" name="gender" id="female" value="F">
    <label for="female">여자</label>
    <br>
    <%-- 라디오박스 (다중 선택 불가능, 택 1) --%>
    <label>국적: </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <%-- 체크박스 (다중 선택 가능) --%>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label>영화보기 </label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label>음악 감상 </label>
    <input type="checkbox" name="hobbies" id="drawing" value="drawing"><label>그림 그리기 </label>
    <br>
    <button type="submit">POST 요청</button>

</form>


</body>
</html>