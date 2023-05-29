package Java_Caffe.java_caffe.controller;

import Java_Caffe.java_caffe.domain.Reservation;
import Java_Caffe.java_caffe.domain.Sit;
import Java_Caffe.java_caffe.dto.UserDto;
import Java_Caffe.java_caffe.repository.SitRepository;
import Java_Caffe.java_caffe.repository.UserRepository;
import Java_Caffe.java_caffe.service.ReservationService;
import Java_Caffe.java_caffe.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

//@RequestMapping("/Login") //mapping 앞부분을 통일시킴
@Controller
@RequiredArgsConstructor
public class MemberController {

    //생성자 주입(롭복의 RequiredArgsConstructor 사용)
    public final SignUpService signUpService;
    public final ReservationService reservationService;
    public final UserRepository userRepository;
    public final SitRepository sitRepository;



    @GetMapping("/signUp")
    public String signUp(){
        return "parameterCheck";
    }

    // SignUp Controller
    @PostMapping("/signUp")
    public String dto(@ModelAttribute UserDto userDto){
        System.out.println("Parameters =>"+userDto );
        signUpService.save(userDto);
        return "login";
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
            return "forward:/main";
        }else {
            //login 실패
            return "Login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession(false); // session값이 존재하는 경우에만 세션을 반환
        if (session != null){
            session.invalidate(); // 세션 값 제거
        }

        return "Login";
    }

    @GetMapping("/main")
    public  String getMain(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("loginId");
        String userName = userRepository.findById(userId).get().getUserName();
        model.addAttribute("userName", userName);

        List<String> sitColor = (List<String>) session.getAttribute("sitColorSession");
        model.addAttribute("sitColor", sitColor);

        return "main";

    }

    @PostMapping("/main")
    public String main(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("loginId");

        String userName = userRepository.findById(userId).get().getUserName();

        model.addAttribute("userName", userName);

        // 자리 사용유무 파악하고 색 정보 보내기(리스트로)
        List<Sit> sitInfo = sitRepository.findAll();
        System.out.println((sitInfo));
        List<String> sitColor = new ArrayList<>();

        for (Sit sitState : sitInfo){
            Integer sitUsingState = sitState.getSitUse();
            if (sitUsingState == 1){
                sitColor.add("#ff0000");
            }else {
                sitColor.add("#ffffff");
            }
        }
        session.setAttribute("sitColorSession", sitColor);
        System.out.println(sitColor);
        model.addAttribute("sitColor", sitColor);


        return "main";
    }

    @GetMapping("/reserv")
    public String reserv(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if (session != null){
            String sessionUserId = (String) session.getAttribute("loginId");
            System.out.println("session useId => " + sessionUserId);

            String userName = userRepository.findById(sessionUserId).get().getUserName();
            Optional<List<Object>> reservationInfo = reservationService.getReservation(sessionUserId);


            model.addAttribute("userName", userName);

            if (reservationInfo.isPresent()){
                System.out.println("Reservation Information => "+reservationInfo.get());
                model.addAttribute("reservInfo", reservationInfo.get());
                return "reserv";
            }else {
                System.out.println("reservation information => " + reservationInfo);
                model.addAttribute("reservInfo", reservationInfo.get());
                return "reserv";
            }

        }else {
            return "forward:/loginWarn";
        }

    }




    @PostMapping("/loginWarn")
    public String loginWarning(){

        return "loginWarning";
    }
}
