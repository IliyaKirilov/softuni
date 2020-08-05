package softuni.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.demo.domain.model.Car;


@Repository
public interface CarRepository extends JpaRepository<Car,String> {



    }
