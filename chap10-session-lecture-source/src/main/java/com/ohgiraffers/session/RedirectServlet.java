package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/redirect")
public class RedirectServlet extends HttpServlet {

    /*  필기. 리다이렉트하는 곳은 항상 GET으로 받아야 함 ? ? ? */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();     // 필기. Session 사물함을 만들 때나, 불러올 때나 같음

        String firstName = session.getAttribute("firstName").toString();    // 더 효율적인 방법이긴 함.
        String lastName = (String) session.getAttribute("lastName");    // String 으로 다운캐스팅 가능

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
//        firstName = 민선
//        lastName = 정

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>당신의 이름은 ")
                .append(firstName)
                .append("<br>그리고 성은 ")
                .append(lastName)
                .append("</h3>");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();



    }
}
