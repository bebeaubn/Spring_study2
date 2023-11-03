package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data   //데이터를 담을수있는 게터 세터 등등 설정 들어감
public class RequestJoin {
    @NotBlank
    @Size(min=6)     //자릿수 유효성 검사  ->1차검증
    private String userId;

    @NotBlank
    @Size(min=8, max=16)     //자릿수 유효성 검사 ->1차검증
    private String userPw;

    @NotBlank
    private String confirmUserPw;

    @NotBlank
    private String UserNm;

    @Email
    @NotBlank
    private String email;
    private String mobile;

    @AssertTrue
    private boolean agree;

    private Address addr;  //addr.address, addr.zipcode


   // private String[] hobby;





    /* 맴버 변수명과 동일한 메서드가 있으면 자동적으로 넣어준다 ->커맨드 -->요청데이터에서 하고자 하는 데이터를 사용하는 경우 (검색) 등등}





     */


}