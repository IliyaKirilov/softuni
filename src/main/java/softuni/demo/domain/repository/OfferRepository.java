package softuni.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.domain.model.Offer;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer,String> {

}
