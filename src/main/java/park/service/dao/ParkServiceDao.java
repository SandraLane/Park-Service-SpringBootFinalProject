package park.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import park.service.entities.ParkService;


public interface ParkServiceDao extends JpaRepository<ParkService, Long> {

}
