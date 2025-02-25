package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet(value = "/header")
public class ResponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        // 시스템의 현재 시간 응답
        long currentTime = System.currentTimeMillis(); // 서버의 현재 시간
        writer.print("<h1>" + currentTime + "</h1>"); 
        writer.print("<h1>" + new java.util.Date(currentTime) + "</h1>"); // 서버의 현재 시간을 Date 형식으로 만든 것
        /*  필기. 클라이언트 측에서 새로 고침을 해야지, 서버의 시간이 갱신됨
        *       ex) polling (n초마다 계속 요청ㅇ을 보내서 갱신하는 방법 - 부하 많음)
        * */
        writer.flush();
        writer.close();

        /*  설명.  response 객체의 header 값에 대한 키-벨류 확인하기(개발자 도구에서도 확인 가능) */
        Collection<String> responseHeaders = resp.getHeaderNames();
        Iterator<String> iter = responseHeaders.iterator();
        while(iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + ": " + resp.getHeader(headerName));
        }
//        Content-Type: text/html;charset=UTF-8
//        Transfer-Encoding: chunked
//        Date: Tue, 25 Feb 2025 11:09:43 GMT
//        Keep-Alive: timeout=20
//        Connection: keep-alive

    }
}
