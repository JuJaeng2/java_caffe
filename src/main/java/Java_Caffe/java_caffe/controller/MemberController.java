package Java_Caffe.java_caffe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/Login")
    public String login(){
        return "Login";
    }
}
