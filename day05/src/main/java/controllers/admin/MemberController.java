package controllers.admin;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
public class MemberController {

    @GetMapping
    public String list(@ModelAttribute @Valid MemberSearch search, Errors errors){   //valid 이거 해달라고 알려주는거
        System.out.println(search);
        return "admin/member/";

    }
    @GetMapping("/{num}/info/{Id}")
    public String info(@PathVariable(name="id" ,required = false) String userId, @PathVariable Integer num){
        System.out.println(userId);
        System.out.println(num);


        return "admin/member/info";

    }
}
