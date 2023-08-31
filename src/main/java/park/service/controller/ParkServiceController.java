package park.service.controller;

import java.util.List;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import park.service.controller.model.CamperData;
import park.service.controller.model.ParkRangerData;
import park.service.controller.model.ParkServiceData;
import park.service.controller.model.ParkServiceData.ParkServiceCamper;
import park.service.controller.model.ParkServiceData.ParkServiceParkRanger;
import park.service.service.ParkServiceService;


@RestController
@RequestMapping("/park_service")
@Slf4j
public class ParkServiceController {
	@Autowired
	private ParkServiceService parkServiceService;
	
	
	@PostMapping("/parkService")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ParkServiceData saveParkService(
		@RequestBody ParkServiceData parkServiceData) {
		log.info("Creating parkService ()", parkServiceData);			
		return parkServiceService.saveParkService(parkServiceData);
	}
	
	 @PostMapping("/parkService/{parkServiceId}/parkServiceParkRanger")	  
	  @ResponseStatus(code = HttpStatus.CREATED) 
	  public ParkServiceParkRanger saveParkRanger(@PathVariable Long parkServiceId,	  
	  @RequestBody ParkServiceParkRanger parkServiceParkRanger) {
	  log.info("Adding ParkRanger () for ParkService with ID= {}", parkServiceId,
	  parkServiceParkRanger); 
	  return parkServiceService.saveParkRanger(parkServiceId, parkServiceParkRanger); 
	  }

	  @PostMapping("/parkService/{parkServiceId}/parkServiceCamper")			  
	  @ResponseStatus(code = HttpStatus.CREATED) 
	  public ParkServiceCamper saveCamper(@PathVariable Long parkServiceId,
	  @RequestBody ParkServiceCamper parkServiceCamper) {
	  log.info("Adding Camper () for ParkService with ID= {}", parkServiceId,
	  parkServiceCamper); 
	  return parkServiceService.saveCamper(parkServiceId, parkServiceCamper); 
	  }	
	  
	  @PutMapping("/parkService/{parkServiceID}") public ParkServiceData
	  updateParkService(@PathVariable Long parkServiceID,		  
	  @RequestBody ParkServiceData parkServiceData) {
	  parkServiceData.setParkServiceId(parkServiceID); 
	  log.info("Updating parkService ()",
	  parkServiceData); 
	  return parkServiceService.saveParkService(parkServiceData); 
	  }	  
		  
		  @GetMapping("/parkService/{parkServiceId}") 
		  	public ParkServiceData retrieveParkServiceById(@PathVariable Long parkServiceId) {
		  		log.info("Retrieving parkService by ID ={) ", parkServiceId);
		  		
		  		return parkServiceService.retrieveParkServiceById(parkServiceId);
		  	}
		  			
			@GetMapping("/parkService")
			public List<ParkServiceData> retrieveAllParkServices() {
					log.info("Retrieve all ParkServices.");
					return parkServiceService.retrieveAllParkServices();
				
				}
				
			@DeleteMapping("/parkService/{parkServiceId}")	
			public Map<String, String> deleteParkServiceById(@PathVariable Long parkServiceId) {
				log.info("Deleting ParkService with ID={)", parkServiceId);
				
				parkServiceService.deleteParkServiceById(parkServiceId);
				
				return Map.of("message", "Deletion of ParkService with ID=" + parkServiceId + " was successful.");
				
			}	
			 @PutMapping("/parkService/{parkServiceId}/parkServiceParkRanger/{parkRangerId}") 
			  public ParkServiceParkRanger updateParkRanger(@PathVariable Long parkRangerId,
			  @RequestBody ParkServiceParkRanger parkServiceParkRanger) {
			  parkServiceParkRanger.setParkRangerId(parkRangerId);
			  log.info("Updating parkServiceParkRanger ()", parkRangerId); 
			  return parkServiceService.saveParkRanger(parkRangerId, parkServiceParkRanger); 
			  }
			
			  
			  @GetMapping("/parkService/{parkServiceId}/parkRanger/{parkRangerId}") 
			  public ParkRangerData retrieveParkRangerById(@PathVariable Long parkRangerId, Long
			  parkServiceId) { 
			  log.info("Retrieving parkRanger by ID={) ", parkRangerId);
			  return parkServiceService.retrieveParkRangerById(parkRangerId, parkServiceId);
			  }
			  
			  @GetMapping("/parkService/parkRanger") 
			  public List<ParkRangerData> retrieveAllParkRangers() { 
			  log.info("Retrieve all ParkRangers."); 
			  return parkServiceService.retrieveAllParkRangers();  
			  }
			  
			  @DeleteMapping("/parkService/{parkServiceId}/parkRanger/{parkRangerId}") 
			  public Map<String, String> deleteParkRangerById(@PathVariable Long parkRangerId,
			  Long parkServiceId) { 
			  log.info("Deleting ParkRanger with ID={)", parkRangerId, parkServiceId);  
			  parkServiceService.deleteParkRangerById(parkRangerId, parkServiceId);  
			  return Map.of("message", "Deletion of ParkRanger with ID=" + parkRangerId +
			  " was successful.");  
			  }
			  
			  @PutMapping("/parkService/{parkServiceId}/parkServiceCamper/{camperID}") 
			  public ParkServiceCamper parkServiceCamper(@PathVariable Long camperId,  
			  @RequestBody ParkServiceCamper parkServiceCamper) { 
			  parkServiceCamper.setCamperId(camperId);
			  log.info("Updating parkServiceParkCamper ()", camperId); 
			  return parkServiceService.saveCamper(camperId, parkServiceCamper); 
			  }	 
			  
			  @GetMapping("/parkService/{parkServiceId}/camper/{camperId}") 
			  public CamperData retrieveCamperById(@PathVariable Long camperId, Long parkServiceId) {
			  log.info("Retrieving camper by ID={) ", camperId); 
			  return parkServiceService.retrieveCamperById(camperId, parkServiceId); 
			  }  
			  
			  @GetMapping("/parkService/camper") 
			  public List<CamperData> retrieveAllCampers() {
			  log.info("Retrieve all Campers."); 
			  return parkServiceService.retrieveAllCampers();  
			  }
			  
			  @DeleteMapping("/parkService/{parkServiceId}/camper/{camperId}") 
			  public Map<String, String> deleteCamperById(@PathVariable Long camperId, Long parkServiceId ) {
			  log.info("Deleting Camper with ID={)", camperId, parkServiceId);  
			  parkServiceService.deleteCamperById(camperId, parkServiceId);  
			  return Map.of("message", "Deletion of Camper with ID=" + camperId +
			  " was successful.");  
			  }  
			  

}


