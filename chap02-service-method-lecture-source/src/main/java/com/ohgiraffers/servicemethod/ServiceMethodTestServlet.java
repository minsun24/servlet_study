package com.ohgiraffers.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    /*  설명.  Service 메소드에만 집중해서 만들어 보기 */
    public ServiceMethodTestServlet() {
        System.out.println("기본 생성자 생성");
    }



    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        System.out.println("req = " + req);
        System.out.println("res = " + res);
//    req = org.apache.catalina.connector.RequestFacade@41cb7174
//    res = org.apache.catalina.connector.ResponseFacade@4f0c873d


        // 다운캐스팅 Servlet -> HTTPServlet
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        /*  필기. 어떤 요청인지 method 정보로 알 수 있음 */
        String httpMethod = httpRequest.getMethod();
        System.out.println("요청 방식: " + httpMethod);
        //  ��û ���: GET

        /*  필기. doGET, doPOST 는 HttpServletRequest, HttpResponse 객체를 인자로 받음
         *       따라서 다운캐스팅 후 전달해줘야 함.*/

        if("GET".equals(httpMethod)) {  // 조회
            doGet(httpRequest, httpResponse);
            // 요청 방식: GET
            // GET 요청을 처리할 메소드 실행 중...
        }else if("POST".equals(httpMethod)) {      // 조회가 아닌 것
            doPost(httpRequest, httpResponse);
            // 요청 방식: POST
            // POST 요청을 처리할 메소드 실행 중...
        }

        
    }



    /*  필기. GET 방식일 때 호출할 메서드 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("GET 요청을 처리할 메소드 실행 중...");
    }

    /*  필기. POST 방식일 때 호출할 메서드 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("POST 요청을 처리할 메소드 실행 중...");
    }






}
