package com.ohgiraffers.redirect.section01.othercite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/othercite")
public class OtheriteRedirectServlet extends HttpServlet {

    /*  필기. a태그로 오는 것이기 때문에, GET요청임 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 받으면 naver 사이트로 redirect ");


        /*  설명.  리다이렉트를 해서 다른 서블릿으로 갈 때 파라미터로 추가하면 어느 정도 상태를 전달할 수 있다. */
        resp.sendRedirect("https://www.naver.com");
        /* 필기. redirect한 곳에서 , 새로고침을 해도 리다렉트된 사이트 그대로 요청된다.
                (실제로 클라이언트의 url이 변경되는 것)
        */
    }
}
