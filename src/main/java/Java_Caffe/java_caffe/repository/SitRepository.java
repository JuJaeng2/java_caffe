package Java_Caffe.java_caffe.repository;

import Java_Caffe.java_caffe.domain.Sit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface SitRepository extends JpaRepository<Sit, Integer> {
    Optional<Sit> findBySitName(String sitName);

}
