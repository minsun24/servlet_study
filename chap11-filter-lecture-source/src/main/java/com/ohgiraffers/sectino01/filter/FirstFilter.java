package com.ohgiraffers.sectino01.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/* 설명.
    @WebFilter 라는 어노테이션을 통해 필터 설정을 할 수 있지만, 필터의 동작 순서를 원하는대로
    동작하게 하기 위해서는 Servlet 에서는 web.xml 을 활용한 xml 방식의 설정을 통해서만 바꿔줄 수 있다.
    (필터의 동작 순서는 web.xml 에 작성한 filter mapping 의 순서에 따라 동작한다.)
 */
/* 설명. /first 이후 경로는 어떤 것이든 지금의 FirstFilter를 거치는 요청 경로가 된다. */

//@WebFilter("/*")      // 모든 경로의 요청에 대해 처리되는 필터를 만들고 싶을 때
//@WebFilter(filterName="firstFilter", urlPatterns="/first/*")
@WebFilter(filterName="firstFilter")
public class FirstFilter implements Filter {
    // 필기. 서블릿의 라이프 사이클과 비슷하다.

    public FirstFilter() {
        System.out.println("First Filter 기본 생성자 호출: 인스턴스 생성!!! ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter의 init 호출");
    }

    // 필기. 서블릿의 서비스 메서드
    /*  필기. 파라미터 중 FilterChain filterChain : 다음 필터가 있으면 다음 필터로 갈 수 있음
        -> 연쇄적인 필터 가능!
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter의 doFilter 호출");
        // 전처리
        /* 설명. FilterChain에서 제공하는 doFilter(req,resp)는 다음 필터 또는 서블릿으로 진행하라는 의미이다.    */
        filterChain.doFilter(servletRequest, servletResponse);  //  포워딩과 비슷. 다음 필터로 위임
        // 다음 필터가 없다면 서블릿으로 이동
        // fil1 -> fil2 -> fil3 -> filx -> servlet
        // 후처리
        System.out.println("서블릿 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter의 destroy 호출");
    }
}
