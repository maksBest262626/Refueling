package refueling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import refueling.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer> {

}
