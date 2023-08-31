//package park.service.controller;
//
//import java.util.List;
//
//import java.util.Set;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.extern.slf4j.Slf4j;
//import park.service.controller.model.CamperData;
//import park.service.controller.model.CamperData.CamperParkRanger;
//import park.service.controller.model.CamperData.CamperParkRanger.CamperParkService;
//import park.service.controller.model.ParkRangerData;
//import park.service.controller.model.ParkServiceData;
//import park.service.controller.model.ParkServiceData.ParkServiceCamper;
//import park.service.controller.model.ParkServiceData.ParkServiceParkRanger;
//import park.service.service.CamperService;
//import park.service.service.ParkServiceService;
//
//
//
//@RestController  
//@RequestMapping("/park_service") 
//@Slf4j 
//public class CamperController {
//	@Autowired 
//	  private CamperService camperService;
//	  
//	  @PutMapping("/{parkServiceId}/parkServiceParkCamper/{camperID}") 
//	  public ParkServiceCamper updateCamper(@PathVariable Long camperId,  
//	  @RequestBody ParkServiceCamper parkServiceCamper) { 
//	  parkServiceCamper.setCamperId(camperId);
//	  log.info("Updating parkServiceParkCamper ()", camperId); 
//	  return camperService.saveCamper(camperId, parkServiceCamper); 
//	  }
//	  
//	  @GetMapping("/{parkServiceId}/camper/{camperId}") 
//	  public CamperData retrieveCamperById(@PathVariable Long camperId, Long parkServiceId) {
//	  log.info("Retrieving camper by ID={) ", camperId); 
//	  return camperService.retrieveCamperById(camperId, parkServiceId); 
//	  }  
//	  
//	  @GetMapping("/camper") public List<CamperData> retrieveAllCampers() {
//	  log.info("Retrieve all Campers."); 
//	  return camperService.retrieveAllCampers();  
//	  }
//	  
//	  @DeleteMapping("/{parkServiceId}/camper/{camperId}") public Map<String, String>
//	  deleteCamperById(@PathVariable Long camperId, Long parkServiceId ) {
//	  log.info("Deleting Camper with ID={)", camperId, parkServiceId);  
//	  camperService.deleteCamperById(camperId, parkServiceId);  
//	  return Map.of("message", "Deletion of Camper with ID=" + camperId +
//	  " was successful.");  
//	  }  
//	  
//	  }

