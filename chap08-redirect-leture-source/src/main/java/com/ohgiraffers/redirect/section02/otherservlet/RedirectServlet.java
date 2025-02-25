package com.ohgiraffers.redirect.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("리다이렉트 이후 request의 attribute 확인 : " + req.getAttribute("test"));
        System.out.println("리다이렉트 이후 request의 parameter 확인: " + req.getParameter("test"));
        /*  필기. forwarding과 달리 redirect는 상태를 공유할 수 없음
         *       (객체가 갈아 끼워져서 유지가 안되는 것=> 다른 객체)
         * */
//        리다이렉트 이후 request의 attribute 확인 : null
//        리다이렉트 이후 request의 parameter 확인: null

        /*  필기. 억지로 URL 경로 상에 파라미터로 넘겨줄 경우  */
//        리다이렉트 이후 request의 attribute 확인 : null
//        리다이렉트 이후 request의 parameter 확인: abc

    }
}
