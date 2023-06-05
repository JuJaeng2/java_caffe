package Java_Caffe.java_caffe.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor // 기본생성자를 자동으로 만들어줌
@AllArgsConstructor
@ToString
public class ReservationDto {

//    private Integer orderId; 이값은 자동 증가로 넣기
    private String sitId; // 자리 이름값이 넘어온다(자리이름으로 자리 아이디 값 찾기)
    private String menueName;
    private String userName;
    private String reservDate;

}
