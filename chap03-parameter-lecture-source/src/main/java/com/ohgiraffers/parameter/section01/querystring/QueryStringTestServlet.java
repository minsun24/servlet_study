package com.ohgiraffers.parameter.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/querystring")
public class QueryStringTestServlet extends HttpServlet {

    public QueryStringTestServlet() {
        System.out.println("QueryStringTestServlet 기본 생성자 호출!! ");
    }
    /* 수업목표. 서비스 계층이 하는 일 */
    /*  설명.  get 요청이 오면 doGet이 실행되고 이때 매개변수로 넘어온 HttpServletRequest에서 꺼낼 수 있다. */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        /*  필기. REQUEST.getParameter("파리미터명") 은 String 을 반환하기 때문에 파싱 필요!    */
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age = " + age);

        // name = 정민선
        // age = 23

        java.sql.Date birthDay = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthDay = " + birthDay);

        String national = req.getParameter("national");
        System.out.println("national = " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        /*  필기. 일차원 배열이므로, Arrays.toString() 으로 출력한다. */
        System.out.println("hobbies=" + Arrays.toString(hobbies));

        // 필기. key, value는 내부적으로 Map 형태로 저장되어 있음.
        // http://localhost:8080/chap03/querystring?name=%EC%A0%95%EB%AF%BC%EC%84%A0&age=23&birthday=2002-02-04&gender=F&national=ko&hobbies=movie&hobbies=music&hobbies=drawing
        // output.
        //name = 정민선
        //age = 23
        //birthDay = 2002-02-04
        //national = ko
        //hobbies=[movie, music, drawing]


    }



}
