package com.ohgiraffers.parameter.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        /*  설명.  톰캣 9버전 이하일 경우,
                  POST 방식 요청일 때 한글이 깨지지 않으려면 UTF-8로 인코딩 설정을 해 주어야 한다. */
        /*  필기. 현재 사용하고 있는 톰캣(10.1.36) 10버전이므로 생략해도 됨!*/
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        /*  설명.  parameter 들을 한번에 순회하며 확인하고 싶을 때, (키 값) */
        /*  필기. 이터레이터 같은 것 */
        Enumeration<String> keyNames = req.getParameterNames();
        while(keyNames.hasMoreElements()){
            System.out.println(keyNames.nextElement());
        }
//        name
//        age
//        birthday
//        gender
//        national
//        hobbies

    }
}
