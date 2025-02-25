package com.ohgiraffers.section03.status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/status")
public class StatusCodeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendError(404, "없는 페이지입니다. 경로를 확인해 주세요.");     // url 잘못 됐을 때
        // 지금은, 제대로 이동해도 임의로 에러를 주는 것
        // 필기. 404 에러 시 보여주는 커스텀 에러 페이지가 필요(안 만들면 코드가 다 노출되는 문제 발생함)

        resp.sendError(500, "서버 내부 오류입니다. 서브 오류는 서버 개발자의 잘못이고, 개발자는 여러분입니다.");
        
    }
}
