package com.ohgiraffers.listener.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


// 필기.ServletContextListener 인터페이스:
//  Context가 생성되고 사라질 때? 이벤트소스를 감지하는 리스너?


@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    public ContextListener() {
        System.out.println("ContextListener 인스턴스 생성됨 !! ");
    }
//  프로그램 시작하자마자 동작함 => ContextListener 인스턴스 생성됨 !!

    // ContextListener 인스턴스가 생성되어야, 아래 초기화 메서드에서도 감지 가능할 것


    // 필기. ServletContextListener 인터페이스 메서드 오버라이딩 ----------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init!! ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroy!!");
    }

    // 필기. ServletContextAttributeListener 인터페이스 메서드 오버라이딩 ----------------
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("attribute added!! " + event.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("attribute removed!! ");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("attribute replaced!! ");
    }
}
