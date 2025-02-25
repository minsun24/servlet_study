package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseText = new StringBuilder();

        // 필기. append의 반환형이  StringBuilder이므로, 계쏙 append로 이어 붙일 수 있음
        responseText.append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>한글 sevlet response</h1>\n")
                    .append("</body>\n")
                    .append("</html>");

        /*  설명.  MIME 타입과 인코딩 설정 (Response에게 전달할 데이터가 어떤 타입인지 설정해주는 것)
        *    톰캣 10 버전 이하에서는 스트림 만들기 전에, 반드시 작성해주어야 한다.
        *    다만 우린 jakarta는 굳이 해주지 않아도 된다.
        * */
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        /*  설명.  스트림 연결 */
        // 필기. Response 객체의 헤더에 담으려면
        // PrintWriter 라는 스트림이 하나 나오게 됨. 문자열을 내보내면
        /* 필기. Reponse 객체는 돌아갈 길을 알고 있는 객체.
                돌아갈 길을 열어주는 것
        */
        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();    // 출력 시 버퍼 비우기
        out.close();    // stream이므로 닫아주어야 함.


    }
}

