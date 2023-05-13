package Java_Caffe.java_caffe.service;

import Java_Caffe.java_caffe.domain.User;
import Java_Caffe.java_caffe.dto.UserDto;
import Java_Caffe.java_caffe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;


    //DB에 값 저장
    public void save(UserDto userDto) {
        //1. dto -> entity 변환
        //2. reposityory의 save메서드 호출

        User user = User.toUserEntity(userDto);
        userRepository.save(user);
        // repoistory의 save메서드 호출 (조건, entity객체를 넘겨줘야함)


    }

    // Login => user확인
    public UserDto login(UserDto userDto) {
        /*
         * 1. 회원이 입력한 이메일로 DB에서 조회를 함
         * 2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         * */


        Optional<User> byUserId = userRepository.findByuserId(userDto.getUserId());
        if (byUserId.isPresent()){
            //조회 결과가 있다 ( 해당 ID를 가진 회원 정보가 있다.)
            User user = byUserId.get();
            if (user.getUserId().equals(userDto.getUserId())){
                // 비밀번호 일치
                //entity -> dto 변환 후 배포
                UserDto dto = UserDto.toUserDto(user);
                return dto;

            }else {
                // 비밀번호 불일치 (로그인 실패)
                return null;
            }
        }else {
            //조회 결과가 없다.(해당 ID를 가진 회원이 없다.)
            return null;
        }

    }
}
