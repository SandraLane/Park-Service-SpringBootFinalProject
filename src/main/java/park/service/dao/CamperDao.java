package park.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import park.service.entity.Camper;

public interface CamperDao extends JpaRepository<Camper, Long> {

}
