package com.ohgiraffers.listener.section01.contextlistener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Context Listener 확인용 서블릿");

        /*필기. ServletContext: 애플리케이션 시작-종료까지 존재하는 저장 공간
                (서블릿 호출할 때 생성되는 것이 아님,)
        */
        ServletContext context = req.getServletContext();

        context.setAttribute("test1", "value1");
        context.setAttribute("test2", "value2");
        context.setAttribute("test2", "value3");    // 수정 -> replaced가 동작할 것

        context.removeAttribute("test2");


    }
}

//    프로그램 시작하자마자 자동으로 담기는 것(프로그램에 필수적으로 필요한 것?)
//    attribute added!! org.apache.jasper.runtime.JspApplicationContextImpl
//    attribute added!! org.apache.jasper.compiler.ELInterpreter
//    attribute added!! org.apache.jasper.compiler.StringInterpreter

//    Context Listener 확인용 서블릿
//    서블릿에서 Attribute 추가, 수정, 삭제한 것들
//    attribute added!! test1
//    attribute added!! test2
//    attribute replaced!!
//    attribute removed!!