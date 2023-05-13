package Java_Caffe.java_caffe.controller;

import Java_Caffe.java_caffe.dto.UserDto;
import Java_Caffe.java_caffe.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//@RequestMapping("/Login") //mapping 앞부분을 통일시킴
@Controller
@RequiredArgsConstructor
public class MemberController {

    //생성자 주입(롭복의 RequiredArgsConstructor 사용)
    public final SignUpService signUpService;



    @GetMapping("/signUp")
    public String signUp(){
        return "parameterCheck";
    }

    // SignUp Controller
    @PostMapping("/signUp")
    public String dto(@ModelAttribute UserDto userDto){
        System.out.println("Parameters =>"+userDto );
        signUpService.save(userDto);
        return "parameterCheck";
    }

    // Login Controller
    @GetMapping("/login")
    public String login(){

        return "Login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, HttpSession session){
        UserDto loginResult = signUpService.login(userDto);

        if (loginResult != null){
            //login 성공
            session.setAttribute("loginId", loginResult.getUserId()); // session을 사용해서 로그인 유지
            return "main";
        }else {
            //login 실패
            return "Login";
        }
    }

}
