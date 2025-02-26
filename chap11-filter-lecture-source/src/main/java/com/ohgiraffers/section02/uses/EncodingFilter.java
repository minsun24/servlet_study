package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class EncodingFilter implements Filter {
    public EncodingFilter() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // HttpServlet이 아니기 때문에 "다운캐스팅" 필요
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명.
        *   톰캣  10버전 이전에는 post 요청일 때, 인코딩 설정을 하지 않으면 한글이 깨지곤 했다.
        *   우린 10버전의 톰캣이라 굳이 해주지 않아도 동작하지만, 현업에서 경우에 따라 필요할 수 있고
        *   추가로 다른 인코딩 설정으로 바꿀 때도 해당 방식의 필터로 활용할 수 있다.
        * */
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(httpRequest, servletResponse);





    }

}

/* 필기. Filter에서 default 인 메서드(init, destroy)는 오버라이딩 필수가 아님 (강제성 x)
*/