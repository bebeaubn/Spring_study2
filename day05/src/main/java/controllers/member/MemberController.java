package controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor  //이걸로 의존성 자동주입후 클래스 final 처리
public class MemberController {

    //@Autowired   //의존성 자동 주입
    private final JoinValidator joinValidator;

    @GetMapping("/join") // /member/join
    public String join(Model model) {
        RequestJoin requestJoin = new RequestJoin();
        // model.addAttribute("requestJoin", requestJoin);
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin join, Errors errors) {

        joinValidator.validate(join, errors);


        if(errors.hasErrors()){
            return "member/Join";
            //검증 실패시 유입
        }

        /* model.addAttribute("requestJoin", join);
           요청 객체와 동일 템플릿에 연결됨 -> 위에 request join 이걸로 한줄에 연결 가능
           요청 데이터가 들어오면 가능 post 방식에 주로 이용됨
           get 방식에 없으면 오류발생

         */


        return "redirect:/member/login";
        //검중 성공 -> 회원가입 처리
    }

    @GetMapping("/login")  // /member/login
    public String join(@ModelAttribute RequestJoin join){   //그냥쓰면 클래스 이름이 기준 value값을 작성하면 작성된 값이 기준

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs() {

        return "member/login";
    }

    /*
    @GetMapping("/member/join")
    public String join(Model model) {
        String[] addCss = {"member/test1", "member/test2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원가입");

        return "member/join";
    }


    @GetMapping("/member/login")
    public String login(Model model) {

        model.addAttribute("userId", "user99");
        model.addAttribute("userPw", "비밀번호");

        return "member/login"; // login.html
    }

    @GetMapping("/member/info")
    public String info(Model model) {

        Member member = Member.builder()
                .userNo(1L)
                .userId("<h1>user01</h1>")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("010-0000-0000")
                .build();

        model.addAttribute("member", member);

        return "member/info";
    }

    @GetMapping("/member/list")
    public String members(Model model) {

        List<Member> members = IntStream.rangeClosed(1, 10).mapToObj(this::addMember).toList();
        model.addAttribute("members", members);

        return "member/list";
    }

    private Member addMember(int i) {
        return Member.builder()
                .userNo(i * 10000)
                .userId("user" + i)
                .userPw("123456")
                .userNm("사용자" + i)
                .email("user"+i+"@test.org")
                .regDt(LocalDateTime.now())
                .build();

    }
     */
}