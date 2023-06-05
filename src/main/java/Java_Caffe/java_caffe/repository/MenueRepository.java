package Java_Caffe.java_caffe.repository;

import Java_Caffe.java_caffe.domain.Menue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenueRepository extends JpaRepository<Menue, Integer> {
    List<Menue> findByMenueName(String menueName);
}
