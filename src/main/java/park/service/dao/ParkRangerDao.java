package park.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import park.service.entity.ParkRanger;

public interface ParkRangerDao extends JpaRepository<ParkRanger, Long> {

		
}
