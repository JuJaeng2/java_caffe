package Java_Caffe.java_caffe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "jReservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Integer reservId;

    @Column(name = "r_date")
    private String reservDate;

    @Column(name = "o_id")
    private Integer reservOrderId;

//    public static Reservation toReservationEntity(ReservationDto reservationDto){
//        Reservation reservation = new Reservation();
//        reservation.setReservDate(reservationDto.getReservDate());
//
//        return reservation;
//
//    }

}
