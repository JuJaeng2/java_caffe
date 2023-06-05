package Java_Caffe.java_caffe.controller;

import Java_Caffe.java_caffe.dto.ReservationDto;
import Java_Caffe.java_caffe.repository.*;
import Java_Caffe.java_caffe.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    public final ReservationService reservationService;
    public final UserRepository userRepository;
    public final MenueRepository menueRepository;
    public final SitRepository sitRepository;
    public final ReservationRepository reservationRepository;
    public final OrderRepository orderRepository;

    @PostMapping("/reservation")
    public String reservationDto(@ModelAttribute ReservationDto reservationDto){
        System.out.println("Reservation Information => " + reservationDto);
        List<Object> orderList = new ArrayList<>();
        List<Object> reservList = new ArrayList<>();
        /*
        <Reservation Entity에 필요한 값>
        => reservId(자동증가), reservDate, reservorderId

        <Order Entity에 필요한 값>
        => orderId(자동증가), orderuserId, orderMenueId, orderSitId

        <reservationDto 목록>
         - sitId(자리 이름) =>
         - menueName
         - userName
         - reservDate
        */

        // 각 entity마다 따로 save메서드 작성후 도작시키기

        // <@Reservation Entity 먼저 작성되야함@>

        //Sit entity
        //1. sitId(자리이름)으로 실제 자리ID값 가져오기
        System.out.println("SitId => "+sitRepository.findBySitName(reservationDto.getSitId()).get().getSitId());
        Integer sitId = sitRepository.findBySitName(reservationDto.getSitId()).get().getSitId(); // 잡고자 하는 자리의 Sit ID

        //Menue entity
        //1. menueName으로 menueId값 가져오기
        Integer menueId = menueRepository.findByMenueName(reservationDto.getMenueName()).get(0).getMenueId();

        //User entity
        //1.userName으로 userId값 가져오기
        String userId = userRepository.findByuserName(reservationDto.getUserName()).get(0).getUserId();

        //Reservation Entity
        String reservDate = reservationDto.getReservDate();


        //Order entity 저장 완료된 후 orderId값 가져오기
        orderList.add(userId);
        orderList.add(menueId);
        orderList.add(sitId);
        reservationService.orderSave(orderList);

        // orderId가져오고 reservation entity에 값 저장
        Integer reservOrderId = orderRepository.findByOrderSitId(sitId).get().getOrderId();
        reservList.add(reservOrderId);
        reservList.add(reservDate);
        reservationService.reservSave(reservList);

        //orderId로 table에서 s_id값 가져와서 해당 자리 사용중으로 바꾸기
        reservationService.usingSit(sitId);


        return "reservSuccess";
    }



}
