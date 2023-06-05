package Java_Caffe.java_caffe.repository;

import Java_Caffe.java_caffe.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


    Optional<Order> findByOrderUserId(String id);

    Optional<Order> findByOrderSitId(Integer sitId);
}
