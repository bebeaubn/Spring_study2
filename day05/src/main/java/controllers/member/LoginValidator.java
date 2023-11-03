package controllers.member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {   //검증할려고하는 컴멘드 객체 알려주는곳
        return clazz.isAssignableFrom(RequestLogin.class);  //다른거 들어오면 검증실패
    }

    @Override
    public void validate(Object target, Errors errors) {  //검증하는곳
        RequestLogin form = (RequestLogin) target;

    }
    /**
     * 1. 아이디가 존재 하는지 체크
     * 2.회원을 조회 -> 비밀번호 검증
     *
     */

}
