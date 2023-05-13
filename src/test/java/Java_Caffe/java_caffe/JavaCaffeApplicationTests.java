//package Java_Caffe.java_caffe;
//
//import Java_Caffe.java_caffe.domain.UserEntity;
//import Java_Caffe.java_caffe.repository.UserRepository;
//import com.fasterxml.jackson.databind.annotation.JsonAppend;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//class JavaCaffeApplicationTests {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Test
//	void TestUser() {
//
//		User user1 = new User();
////		user1.setU_id(1);
//		user1.setU_name("테스트");
//		user1.setU_pw("Test1234");
//		this.userRepository.save(user1);
//
////		User user2 = new User();
////		user1.setU_id(2);
////		user2.setU_name("홍길동");
////		user2.setU_pw("Test5678");
////		this.userRepository.save(user2);
//
//	}
//
//	@Test
//	void FindUser(){
//
//		List<User> all = this.userRepository.findAll();
//		System.out.println("순수 데이터 : " + all);
//		System.out.println("get()메서드 : "+all.get(0));
//		System.out.println("테스트 => " + all.get(0).getU_name());
//
//
//	}
//
//	@Test
//	void FindById(){
//
//		Optional<User> userId = this.userRepository.findById(1);
//		if (userId.isPresent()){
//			System.out.println("순수 데이터 : "+userId);
//			System.out.println("get()메서드 사용 : "+userId.get());
//			System.out.println("get()메서드 + getU_name() : "+userId.get().getU_name());
//		}
//	}
//
//	@Test
//	void FindByName(){
//
//		List<User> userName = this.userRepository.findByuserName("홍길동");
//		System.out.println(userName.get(3).getU_id());
//	}
//}
