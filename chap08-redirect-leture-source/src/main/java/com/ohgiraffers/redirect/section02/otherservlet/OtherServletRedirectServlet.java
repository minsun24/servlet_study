package com.ohgiraffers.redirect.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/otherservlet")
public class OtherServletRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test", "abc"); //test 키에 abc 객체를 담을래.
//        resp.sendRedirect("redirect");

        // 필기. 리다이렉트된 곳에서도 값이 보이나?
        // 필기. 편법 -> 파라미터로 넘기기
        resp.sendRedirect("redirect?test=abc");
    }
}
