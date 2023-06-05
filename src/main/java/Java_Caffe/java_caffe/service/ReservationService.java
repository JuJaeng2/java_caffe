package Java_Caffe.java_caffe.service;

import Java_Caffe.java_caffe.domain.Order;
import Java_Caffe.java_caffe.domain.Reservation;
import Java_Caffe.java_caffe.domain.Sit;
import Java_Caffe.java_caffe.domain.User;
import Java_Caffe.java_caffe.dto.ReservationDto;
import Java_Caffe.java_caffe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final OrderRepository orderRepository;
    private final MenueRepository menueRepository;
    private final SitRepository sitRepository;
    private final UserRepository userRepository;

    // 예약정보 가져오기
    public Optional<List<Object>> getReservation(String id) {

        // 주분 번호 찾기
        Optional<Order> orderId = orderRepository.findByOrderUserId(id);

//        System.out.println("Order ID => "+orderId.get().getOrderId());


        if (orderId.isPresent()){

            // 찾은 주문번호를 통해서 자리아이디, 메뉴아이디, 예약 아이디 찾기
            String userName = userRepository.findById(id).get().getUserName();

            Integer menueId = orderId.get().getOrderMenueId(); // 메뉴이름 가져오기
            String menueName = menueRepository.findById(menueId).get().getMenueName();

            Integer sitId = orderId.get().getOrderSitId(); // 그래도 사용

            Integer reservOrderId = orderId.get().getOrderId();
            Optional<Reservation> reservInfo = reservationRepository.findByReservOrderId(reservOrderId);
            Integer reservId = reservInfo.get().getReservId(); // 날짜 값 가져오기
            String reservDate = reservationRepository.findById(reservId).get().getReservDate();

            Optional<List<Object>> reservationInfo = Optional.ofNullable(new ArrayList<>());
            reservationInfo.get().add(userName); //0
            reservationInfo.get().add(reservId); //1
            reservationInfo.get().add(reservDate); //2
            reservationInfo.get().add(orderId.get().getOrderId()); //3
            reservationInfo.get().add(sitId); //4
            reservationInfo.get().add(menueName); //5

            return reservationInfo;
        }else {
            Optional<List<Object>> nullValue= Optional.ofNullable(new ArrayList<>());
            System.out.println("NullValue => " + nullValue);
            return nullValue;
        }

    }


    public void reservSave(List<Object> reservList) {
        Reservation reservation = new Reservation();
        reservation.setReservOrderId((Integer) reservList.get(0));
        reservation.setReservDate((String) reservList.get(1));
        reservationRepository.save(reservation);
    }

    public void orderSave(List<Object> orderList) {
        Order order = new Order();
        order.setOrderUserId((String) orderList.get(0));
        order.setOrderMenueId((Integer) orderList.get(1));
        order.setOrderSitId((Integer) orderList.get(2));
        orderRepository.save(order);
    }

    public void usingSit(Integer sitId){
        Sit sitState = sitRepository.findById(sitId).get();
        sitState.setSitUse(1);
        sitRepository.save(sitState);
    }

    public void notUsingSit(Integer sitId){
        Sit sitState = sitRepository.findById(sitId).get();
        sitState.setSitUse(0);
        sitRepository.save(sitState);

    }
}
