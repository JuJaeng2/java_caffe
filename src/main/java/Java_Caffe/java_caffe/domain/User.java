package Java_Caffe.java_caffe.domain;

import Java_Caffe.java_caffe.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "jUser")
public class User {

    @Id
    @Column(name = "u_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "u_name")
    private String userName;
    @Column(name = "u_pw")
    private String userPassword;
//    @Column(name = "o_id")
//    private Integer userOrderId;

    public static User toUserEntity(UserDto userDto){ // dto에 담겨온 파라미터를 entity객체로 넘기는 작업
        User user = new User();
        user.setUserName(userDto.getSignupName());
        user.setUserId(userDto.getSignupId());
        user.setUserPassword(userDto.getSignupPassword());
        return user;
    }


}
