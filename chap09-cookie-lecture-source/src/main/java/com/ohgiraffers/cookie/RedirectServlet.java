package com.ohgiraffers.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(value="/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*  설명.  클라이언트의 브라우저에 있는 모든 쿠키 값은 request header에 같이 실려 온다.*/
        Cookie[] cookies = req.getCookies();
//        System.out.println(Arrays.toString(cookies));
//        [jakarta.servlet.http.Cookie@f95a8082,
//        jakarta.servlet.http.Cookie@f572c284, jakarta.servlet.http.Cookie@7709025e]

        String firstName = "";
        String lastName = "";
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
            if(cookie.getName().equals("firstName")) {
                firstName = cookie.getValue();
            }else if(cookie.getName().equals("lastName")) {
                lastName = cookie.getValue();
            }
        }
//        JSESSIONID 4A05F7DF44F98CB7FF98EE943E7D2B92
//        firstName 민선
//        lastName 정
        // 필기. 저는 Idea-db... 가 없는데
        StringBuilder responseText = new StringBuilder();

        responseText.append("<h3>당신의 이름은 ")
                .append(firstName)
                .append("<br> 그리고 성은 ")
                .append(lastName)
                .append("</h3>");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();

    }
}
