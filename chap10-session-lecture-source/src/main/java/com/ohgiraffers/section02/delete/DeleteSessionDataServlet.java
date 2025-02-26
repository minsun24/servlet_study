package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value="/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("attribute 무효화 전 firstName: " + session.getAttribute("firstName"));
        System.out.println("attribute 무효화 전 lastName: " + session.getAttribute("lastName"));

//        attribute 만료 전 firstName: 민선
//        attribute 만료 전 lastName: 정

        session.invalidate();   // HttpSession 객체의 Attribute 값들을 무효화(로그아웃 개념으로 많이 쓰게 된다.)
//        System.out.println("attribute 무효화 후 firstName: " + session.getAttribute("firstName"));
//        System.out.println("attribute 무효화 후 lastName: " + session.getAttribute("lastName"));
        // 500 에러. : getAttribute 세션이 이미 무효화되었습니다.
        // 그냥 지우는 정도가 아니고, 아예 무효화

        /* 설명. session이 무효화되어 attribute 를 가져올 수 없게 된다. (가져오려고 하면 500 에러 발생) */





    }
}
