package Java_Caffe.java_caffe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "jOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Integer orderId;

    @Column(name = "u_id")
    private String orderUserId;

    @Column(name = "m_id")
    private Integer orderMenueId;

    @Column(name = "s_id")
    private Integer orderSitId;

    //    @Column(name = "r_id")
//    private Integer orderReservId;

}
