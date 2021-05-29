package refueling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refueling.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
