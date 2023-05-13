package Java_Caffe.java_caffe.dto;


import Java_Caffe.java_caffe.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본생성자를 자동으로 만들어줌
@AllArgsConstructor
@ToString
public class UserDto {

    /*
    * POST방식으로 오는 파라미터의 name과 일치해야 한다.
    * */

    //Login DTO
    private String userId;
    private String userPassword;

    //Sign Up DTO
    private String signupName;
    private String signupId;
    private String signupPassword;

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserPassword(user.getUserPassword());
        return userDto;
    }
}
