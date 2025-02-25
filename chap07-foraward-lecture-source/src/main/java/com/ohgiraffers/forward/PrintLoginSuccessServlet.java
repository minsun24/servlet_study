package com.ohgiraffers.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    /*  필기. 위임한 상위 서블릿이 처리한 요청(GET, POST...)대로 받아야 함 
    *        위임한 서블릿 확인 후 처리 필요
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*  필기. request에 잘 담겨왓는지 확인 */
        System.out.println("==== 포워딩 되어 서블릿에서 넘겨 받은 request 객체에 담긴 값 확인 ====");
        System.out.println("이름: " + req.getAttribute("userName"));

//      문제. 아이디 값만 null로 나왔는데, getAttribute로 받고 있었다.
//      userId는 setAttribute()로 설정된 적이 없기 때문에 null이 반환된 것
//        System.out.println("아이디: " + req.getAttibute("userId"));
        // 필기. userId와 password는 getParemeter 로 받아서 처리해야 함.
        System.out.println("아이디: " + req.getParameter("userId"));
        System.out.println("패스워드: "+ req.getParameter("password"));
//        ==== 포워딩 되어 서블릿에서 넘겨 받은 request 객체에 담긴 값 확인 ====
//        이름: 홍길동
//        아이디: admin
//        패스워드: 1234


        String userName = (String) req.getAttribute("userName");

        /*  필기. 재료로 화면 만들기 ~ ~ ~ */
        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>")
                .append(userName)
                .append("님 환영합니다. </h3>");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();


    }
}
