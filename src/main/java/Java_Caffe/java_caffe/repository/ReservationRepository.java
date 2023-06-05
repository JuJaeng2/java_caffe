package Java_Caffe.java_caffe.repository;

import Java_Caffe.java_caffe.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


    Optional<Reservation> findByReservOrderId(Integer reservOrderId);
}
