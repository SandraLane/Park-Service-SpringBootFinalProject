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
import park.service.service.ParkServiceService;


@RestController
@RequestMapping("/park_service")
@Slf4j
public class ParkServiceController {
	@Autowired
	private ParkServiceService parkServiceService;
	
	//add park 
	@PostMapping("/parkService")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ParkServiceData saveParkService(
		@RequestBody ParkServiceData parkServiceData) {
		log.info("Creating parkService ()", parkServiceData);			
		return parkServiceService.saveParkService(parkServiceData);
	}
	
	 //add park ranger by park service id
	 @PostMapping("/parkService/{parkServiceId}/parkServiceParkRanger")	  
	  @ResponseStatus(code = HttpStatus.CREATED) 
	  public ParkRangerData saveParkRanger(@PathVariable Long parkServiceId,	  
	  @RequestBody ParkRangerData parkRangerData) {
	  log.info("Adding ParkRanger () for ParkService with ID= {}", parkServiceId,
	  parkRangerData); 
	  return parkServiceService.saveParkRanger(parkServiceId, parkRangerData); 
	  }
	  
	  //add camper by park service id
	  @PostMapping("/parkService/{parkServiceId}/parkServiceCamper")			  
	  @ResponseStatus(code = HttpStatus.CREATED) 
	  public CamperData saveCamper(@PathVariable Long parkServiceId,
	  @RequestBody CamperData camperData) {
	  log.info("Adding Camper () for ParkService with ID= {}", parkServiceId,
	  camperData); 
	  return parkServiceService.saveCamper(parkServiceId, camperData); 
	  }	
	  
	  //update park service by park service id
	  @PutMapping("/parkService/{parkServiceID}") public ParkServiceData
	  updateParkService(@PathVariable Long parkServiceID,		  
	  @RequestBody ParkServiceData parkServiceData) {
	  parkServiceData.setParkServiceId(parkServiceID); 
	  log.info("Updating parkService ()",
	  parkServiceData); 
	  return parkServiceService.saveParkService(parkServiceData); 
	  }	  
		  
	      //retrieve park service by park service id
		  @GetMapping("/parkService/{parkServiceId}") 
		  	public ParkServiceData retrieveParkServiceById(@PathVariable Long parkServiceId) {
		  		log.info("Retrieving parkService by ID ={) ", parkServiceId);
		  		
		  		return parkServiceService.retrieveParkServiceById(parkServiceId);
		  	}
		  	
		    //retrieve all park services
			@GetMapping("/parkService")
			public List<ParkServiceData> retrieveAllParkServices() {
					log.info("Retrieve all ParkServices.");
					return parkServiceService.retrieveAllParkServices();
				
				}
			
			//delete park by park service id	
			@DeleteMapping("/parkService/{parkServiceId}")	
			public Map<String, String> deleteParkServiceById(@PathVariable Long parkServiceId) {
				log.info("Deleting ParkService with ID={)", parkServiceId);
				
				parkServiceService.deleteParkServiceById(parkServiceId);
				
				return Map.of("message", "Deletion of ParkService with ID=" + parkServiceId + " was successful.");
				
			}	
			
			 //Update park ranger by park ranger id and park service id
			 @PutMapping("/parkService/{parkServiceId}/parkServiceParkRanger/{parkRangerId}") 
			  public ParkRangerData updateParkRanger(@PathVariable Long parkRangerId,
			  @RequestBody ParkRangerData parkRangerData) {
			  parkRangerData.setParkRangerId(parkRangerId);
			  log.info("Updating parkServiceParkRanger ()", parkRangerId); 
			  return parkServiceService.saveParkRanger(parkRangerId, parkRangerData); 
			  }
			
			  //retrieve park ranger by id and park service id they are assigned to
			  @GetMapping("/parkService/{parkServiceId}/parkRanger/{parkRangerId}") 
			  public ParkRangerData retrieveParkRangerById(@PathVariable Long  parkServiceId, @PathVariable Long parkRangerId) { 
			  log.info("Retrieving parkRanger by ID={) ", parkRangerId);
			  return parkServiceService.retrieveParkRangerById(parkServiceId, parkRangerId);
			  }
			  
			  //retrieve all park rangers
			  @GetMapping("/parkService/parkRanger") 
			  public List<ParkRangerData> retrieveAllParkRangers() { 
			  log.info("Retrieve all ParkRangers."); 
			  return parkServiceService.retrieveAllParkRangers();  
			  }
			  
			  //delete Park Ranger by id and park service id
			  @DeleteMapping("/parkService/{parkServiceId}/parkRanger/{parkRangerId}") 
			  public Map<String, String> deleteParkRangerById(@PathVariable Long parkRangerId,
			  @PathVariable Long parkServiceId) { 
			  log.info("Deleting ParkRanger with ID={)", parkRangerId, parkServiceId);  
			  parkServiceService.deleteParkRangerById(parkServiceId, parkRangerId);  
			  return Map.of("message", "Deletion of ParkRanger with ID=" + parkRangerId +
			  " was successful.");  
			  }
			  
			  //Update camper by camper id and park service id
			  @PutMapping("/parkService/{parkServiceId}/parkServiceCamper/{camperID}") 
			  public CamperData updateCamper (@PathVariable Long parkServiceId, @PathVariable Long camperId,  
			  @RequestBody CamperData camperData) { 
			  camperData.setCamperId(camperId);
			  log.info("Updating parkServiceParkCamper ()", camperId); 
			  return parkServiceService.saveCamper(parkServiceId, camperData); 
			  }	 
			  
			  //Retrieve camper by Id from Park Service by park Service Id
			  @GetMapping("/parkService/{parkServiceId}/camper/{camperId}") 
			  public CamperData retrieveCamperById (@PathVariable Long parkServiceId, @PathVariable Long camperId) {
			  log.info("Retrieving camper by ID={) ", camperId); 
			  return parkServiceService.retrieveCamperById(parkServiceId, camperId); 
			  }  
			  
			  //Retrieve all campers
			  @GetMapping("/parkService/camper") 
			  public List<CamperData> retrieveAllCampers() {
			  log.info("Retrieve all Campers."); 
			  return parkServiceService.retrieveAllCampers();  
			  }
			  
			  //Delete camper by camper id and park service 
			  @DeleteMapping("/parkService/{parkServiceId}/camper/{camperId}") 
			  public Map<String, String> deleteCamperById(@PathVariable Long parkServiceId, @PathVariable Long camperId ) {
			  log.info("Deleting Camper with ID={)", camperId, parkServiceId);  
			  parkServiceService.deleteCamperById(parkServiceId, camperId);  
			  return Map.of("message", "Deletion of Camper with ID=" + camperId +
			  " was successful.");  
			  }  
			  

}


