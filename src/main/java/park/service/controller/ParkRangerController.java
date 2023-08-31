//package park.service.controller;
//
//import java.util.List;
//
//import java.util.Map;
//
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
//import park.service.controller.model.ParkRangerData;
//import park.service.controller.model.ParkRangerData.ParkRangerCamper.ParkRangerParkService;
//import park.service.controller.model.ParkServiceData;
//import park.service.controller.model.ParkServiceData.ParkServiceParkRanger;
//import park.service.service.ParkRangerService;
//import park.service.service.ParkServiceService;
//
//@RestController  
//@RequestMapping("/park_service")  
//@Slf4j 
//public class ParkRangerController {
//	@Autowired 
//	  private ParkRangerService parkRangerService;
//	  
//	  
//	  @PutMapping("/parkService/{parkServiceId}/parkServiceParkRanger/{parkRangerId}") 
//	  public ParkServiceParkRanger updateParkRanger(@PathVariable Long parkRangerId,
//	  @RequestBody ParkServiceParkRanger parkServiceParkRanger) {
//	  parkServiceParkRanger.setParkRangerId(parkRangerId);
//	  log.info("Updating parkServiceParkRanger ()", parkRangerId); 
//	  return parkRangerService.saveParkRanger(parkRangerId, parkServiceParkRanger); 
//	  }
//	  
//	  
//	  @GetMapping("/parkService/{parkServiceId}/parkRanger/{parkRangerId}") 
//	  public ParkRangerData retrieveParkRangerById(@PathVariable Long parkRangerId, Long
//	  parkServiceId) { 
//	  log.info("Retrieving parkRanger by ID={) ", parkRangerId);
//	  return parkRangerService.retrieveParkRangerById(parkRangerId, parkServiceId);
//	  }
//	  
//	  @GetMapping("/parkService/parkRanger") public List<ParkRangerData>
//	  retrieveAllParkRangers() { log.info("Retrieve all ParkRangers."); return
//	  parkRangerService.retrieveAllParkRangers();  
//	  }
//	  
//	  @DeleteMapping("/parkService/{parkServiceId}/parkRanger/{parkRangerId}") public
//	  Map<String, String> deleteParkRangerById(@PathVariable Long parkRangerId,
//	  Long parkServiceId) { log.info("Deleting ParkRanger with ID={)",
//	  parkRangerId, parkServiceId);  
//	  parkRangerService.deleteParkRangerById(parkRangerId, parkServiceId);  
//	  return Map.of("message", "Deletion of ParkRanger with ID=" + parkRangerId +
//	  " was successful.");  
//	  }
//	  
//	  }
//	  
//	  
//	  
	  
	  

