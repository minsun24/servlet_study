package com.ohgiraffers.sectino01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(filterName="secondFilter", urlPatterns="/first/*")
@WebFilter(filterName="secondFilter")
public class SecondFilter implements Filter {
    public SecondFilter() {
        System.out.println("SecondFilter 인스턴스 생성! ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter init 호출! ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter doFilter 호출! ");

        filterChain.doFilter(servletRequest, servletResponse);  //  포워딩과 비슷. 다음 필터로 위임
        System.out.println("서블릿 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter destroy 호출! ");

    }
}

/*
    First Filter 기본 생성자 호출: 인스턴스 생성!!!
    FirstFilter의 init 호출
    SecondFilter 인스턴스 생성!
    SecondFilter init 호출!
    FirstFilter의 doFilter 호출
    SecondFilter doFilter 호출!
    서블릿으로 get 요청 도착 확인!
    서블릿 다녀온 후
    서블릿 다녀온 후
    필기. 어노테이션만으로는 필터의 실행 순서를 설정할 수 없음.
          (web.xml 에서 설정해주어야 함)

 */