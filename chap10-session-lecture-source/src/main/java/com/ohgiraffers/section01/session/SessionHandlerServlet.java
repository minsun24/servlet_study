package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value="/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /*  설명.
        *       요청이 서블릿으로 들어올 때,
        *       HttpServletRequest에는 JESSIONID라는 값이 Header에 같이 포함되어 넘어온다.
        *       그때 해당 JESSIONID에 맞는 HttpSession 객체를 생성해서 해당 사용자를 위한 전용 저장 공간을 제공하게 된다.
        *       (요청을 보낸 사람 전용 Session 저장 공간 생성)
        * */
        HttpSession session = req.getSession(); // 자신의 헤더에 JSESSIONID가 있을 경우, 해당 ID에 맞는 세션 공간을 마련함

        System.out.println("session 객체의 default 만료 시간(초): " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);    // 초 단위 -> 10분으로 수정

        System.out.println("session 객체의 수정 후 만료 시간(초): " + session.getMaxInactiveInterval());

        System.out.println("session id(해당 session JESSIONID): " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");

//        session 객체의 default 만료 시간(초): 1800 -> 30분이 기본
//        session 객체의 수정 후 만료 시간(초): 600
//        session id(해당 session JESSIONID): 0FB87C64E9CC11B9A792726A1EC52EA7

    }
}
