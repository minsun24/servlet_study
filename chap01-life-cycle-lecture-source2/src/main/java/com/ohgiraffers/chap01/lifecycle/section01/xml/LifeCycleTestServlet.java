package com.ohgiraffers.chap01.lifecycle.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {

    /*  설명.  기본 생성자 */
    public LifeCycleTestServlet() {
        System.out.println("xml 방식 서블릿 기본 생성자 실행!");
    }
    
    // HttpServlet으로 만든 것
    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        // 필기. 객체 생성 시 자동 실행되는 메서드
        System.out.println("xml 매핑 init() 메소드 호출!");
    }

    // 할아버지-generic servlet 으로 만든 것 ?
    @Override
    public void destroy() {
//        super.destroy();
        // 필기. 톰캣이 꺼지면서 자신이 관리하던 객체를 소멸시킴 (소멸시키기 전에, destory 메서드가 실행됨)
        System.out.println("xml 매핑 destroy() 메소드 호출!");
    }
    /* 필기. 객체 생성-소멸은 실행 당 한 번 호출되는 것
            객체 생성 후 서블릿으로 요청이 날라오면 그때마다 service() 라는 메서드가 호출됨
     */
    // ServletRequest 로부터 상속받은 것(http 말고 다른 것들이 와도 받아낼 수 있음 -> 다형성)
    // http 붙은 것들은 DIP (?) 
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        System.out.println("xml 매핑 service() 메소드 호출!");
    }

}
