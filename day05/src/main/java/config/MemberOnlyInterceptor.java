package config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.members.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();  //멤버인지 아닌지 가져와서 멤버이면 마이ㅠㅔ이지
        Member member = (Member) session.getAttribute("member");
        if (member != null) { //로그인한 상태
            return true; // 컨트롤러 빈을 실행 ->응답

    }


        //비회원일때는 로그인 페이지로 이동
        String url =request.getContextPath() + "/member/login";
        response.sendRedirect(url);


        return false;



    }
}
