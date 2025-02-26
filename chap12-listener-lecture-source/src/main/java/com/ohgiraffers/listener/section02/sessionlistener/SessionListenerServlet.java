package com.ohgiraffers.listener.section02.sessionlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. 사용자가 입력한 값을 꺼내 DB에서 일치하는 화면을 찾고(로그인 성공)
        *       해당 회원 정보를 session 에 담는 느낌의 예제
        * */
        HttpSession session = req.getSession();
        System.out.println("Servlet에서 session 출력: " + session.getClass().getName());

        // 필기. 객체를 사용하지 않을 경우
        session.setAttribute("userName", "honggildong");    // add
        session.setAttribute("age", 20);    // add
        session.setAttribute("age", 21);    // replace
        session.removeAttribute("userName");    // remove

        // 필기. valueBound, Unbound 가 추가로 동작
        session.setAttribute("user", new UserDTO("홍길동", 10));
        session.removeAttribute("user");



    }
}


//    console output -----------------------------------------------------
//    Servlet에서 session 출력: org.apache.catalina.session.StandardSessionFacade
//    session attribute added!!
//    session에 추가된 attr: userName, value: honggildong
//    session attribute added!!
//    session에 추가된 attr: age, value: 20
//    session attribute replaced!!
//    session attribute removed!!


//    UserDTO 객체가 담김
//    session attribute added!!
//    session에 추가된 attr: user, value: UserDTO{name='홍길동', age=10}
//    UserDTO 객체가 제거됨
//    session attribute removed!!
