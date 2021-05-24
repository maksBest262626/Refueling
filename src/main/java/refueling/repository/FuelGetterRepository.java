package refueling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refueling.model.FuelGetter;
import refueling.model.Request;

@Repository
public interface FuelGetterRepository extends JpaRepository<FuelGetter,Integer> {
}
