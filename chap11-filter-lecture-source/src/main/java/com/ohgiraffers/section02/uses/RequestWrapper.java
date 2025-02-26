package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {
        // 필기. 기존 super : 키에 따른 값을 바로 반환해줌
        /* 설명. "password" 라는 키 값으로 getParameter 메소드 사용 시에는 암호화된 값을 반환하도록 재정의    */
        String value = "";
        if("password".equals(key)){ // 키 값으로 "password"가 넘어올 때
            System.out.println("패스워드 꺼낼 시, ");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 필기. 패스워드 인코더 객체 생성
            value = passwordEncoder.encode(super.getParameter(key));
            // 필기. super.getParameter(key):  원래 평문(plain text)을 넣으면 digest(암호화된 값)이 반환됨
            System.out.println("암호화된 이후: " + value);
        }else{      // 그 외의 입력은 기존과 동일하게 동작
            super.getParameter(key);
        }

        return value;
    }

//    패스워드 꺼낼 시,
//    암호화된 이후: $2a$10$(여기까지가, Hash)   (여기서부터가 salt)Zb3yuAb2t.QfkJDCom1fy.vRPVAM5nil0xaYLcwRlzFf.n11ZnPlq
//            userId =
//            password = $2a$10$Zb3yuAb2t.QfkJDCom1fy.vRPVAM5nil0xaYLcwRlzFf.n11ZnPlq
//    name =
//    패스워드 꺼낼 시,
//    암호화된 이후: $2a$10$   8ALPSf6QHT3LoOxzjUmOO.gFHEtLxeuqOJUkLcd/dN0m2ckGlGQa2
//            userId =
//            password = $2a$10$8ALPSf6QHT3LoOxzjUmOO.gFHEtLxeuqOJUkLcd/dN0m2ckGlGQa2
//    name =


}
