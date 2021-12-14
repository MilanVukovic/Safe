package wartungsplan.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wartungsplan.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

}
