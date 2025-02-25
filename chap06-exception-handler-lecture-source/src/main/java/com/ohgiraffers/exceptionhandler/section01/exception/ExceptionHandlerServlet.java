package com.ohgiraffers.exceptionhandler.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value="/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*  필기. 전달받은 Attribute 키 값 확인하기 */
        Enumeration<String> attrNames = req.getAttributeNames();
        while(attrNames.hasMoreElements()){
            System.out.println(attrNames.nextElement());
        }
//        jakarta.servlet.forward.request_uri
//        jakarta.servlet.forward.context_path
//        jakarta.servlet.forward.servlet_path
//        jakarta.servlet.forward.mapping
//        jakarta.servlet.error.message
//        jakarta.servlet.error.servlet_name
//        jakarta.servlet.error.request_uri
//        jakarta.servlet.error.status_code

        /*  필기. getAttibute("키값")의 반환형은 Object이기 때문에 다운캐스팅 필요 */
        int statusCode = (int)req.getAttribute("jakarta.servlet.error.status_code");
        System.out.println("statusCode = " + statusCode);
        // 404

        /*  필기. attribute 메세지 뽑아보기 */
        String message = (String)req.getAttribute("jakarta.servlet.error.message");
        System.out.println("message = " + message);
        // messgae = 페이지를 못 찾겠어요! ㅜㅜ

        String servletName = (String)req.getAttribute("jakarta.servlet.error.servlet_name");
        System.out.println("servletName = " + servletName);


        /*  설명.  위의 재료를 가지고 만드는 동적인 에러 페이지 생성 및 응답 */
        /*  필기. 동적인 페이지 -> WAS 서버가 담당*/
        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<h1>")
                .append(statusCode)
                .append("-")
                .append(message)
                .append("</h1>")
                .append("<br>\n")
                .append("<p> 에러 발생한 서블릿 명: ")
                .append(servletName)
                .append("</p>");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(errorPage);
        out.flush();
        out.close();


    }
}
