package softuni.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.domain.model.Race;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface RaceRepository extends JpaRepository<Race,String> {
    Optional<Race> findByName(String name);

}
