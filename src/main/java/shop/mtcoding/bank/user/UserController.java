package shop.mtcoding.bank.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// 이 클래스가 Spring MVC의 컨트롤러임을 나타냅니다.
// Lombok 어노테이션으로, final 필드에 대해 생성자를 자동으로 생성합니다.
@Controller
@RequiredArgsConstructor
public class UserController {

    // UserService를 주입받기 위한 final 필드
    private final UserService userService;

    // 회원가입 폼을 보여주는 GET 요청
    @GetMapping("/join-form")
    public String joinForm(){
        return "user/join-form";
    }

    // 회원가입 요청을 처리하는 POST 요청
    @PostMapping("/join")
    public String  join(UserRequest.JoinDTO reqDTO) {

        // userService의 join메서드 호출
        userService.join(reqDTO);

        // 회원가입 완료 후 로그인 페이지로 리다이렉트
        return "redirect:/login-form";
    }

    // 로그인 폼을 보여주는 GET 요청
    @GetMapping("/login-form")
    public String loginForm(){
        return "user/login-form";
    }

    // 로그인 요청을 처리하는 POST 요청
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO){

        // userService의 login 메서드 호출
        userService.login(reqDTO);

        return "redirect:/account/list";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/account/list"; // 페이지를 찾는게 아니라, api 주소 찾기
    }
}
