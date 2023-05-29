package Java_Caffe.java_caffe.repository;

import Java_Caffe.java_caffe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional; // null 방지를 해주는 클래스
@Repository
//쉽게말해서 dml ddl 등의 sql문을 ORM으로 사용하는 곳
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByuserName(String userName); // entity에서의 변수명과 동일하면 알아서 'findBy' + 변수명 이런식으로 메서드 만듦

    //이메일로 회원 정보 조회
    Optional<User> findByuserId(String userId);
}
