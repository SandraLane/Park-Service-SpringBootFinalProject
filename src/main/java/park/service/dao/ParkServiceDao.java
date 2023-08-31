package park.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import park.service.entity.ParkService;


public interface ParkServiceDao extends JpaRepository<ParkService, Long> {

}
