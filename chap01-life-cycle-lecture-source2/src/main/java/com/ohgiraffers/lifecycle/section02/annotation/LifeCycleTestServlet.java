package com.ohgiraffers.lifecycle.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// 필기. 해당 요청이 오면 이 서블릿을 실행해주라는 뜻
@WebServlet(value="/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {

    public LifeCycleTestServlet() {
        System.out.println("annotation 방식 기본 생성자 실행!");
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        System.out.println("annotaion 매핑 init() 메소드 호출! ");
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("annotation 매핑 destory() 메소드 호출! ");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        System.out.println("annotation 매핑 service() 메소드 호출! ");
    }
}
