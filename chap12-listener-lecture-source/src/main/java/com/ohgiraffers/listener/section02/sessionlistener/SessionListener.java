package com.ohgiraffers.listener.section02.sessionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListener() {
        System.out.println("SessionListener 인스턴스 생성됨!");
    }
    //
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session attribute created!!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session attribute destroyed!!");
    }

    //
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session attribute replaced!!");

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!!");

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session attribute added!!");
        System.out.println("session에 추가된 attr: " + event.getName() + ", value: " + event.getValue());
        //
    }
}


