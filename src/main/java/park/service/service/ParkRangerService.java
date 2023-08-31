//package park.service.service;
//
//import park.service.controller.model.ParkRangerData;
//
//
//import park.service.controller.model.ParkRangerData.ParkRangerCamper.ParkRangerParkService;
//import park.service.controller.model.ParkServiceData;
//import park.service.controller.model.ParkServiceData.ParkServiceParkRanger;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import park.service.dao.CamperDao;
//import park.service.dao.ParkRangerDao;
//import park.service.dao.ParkServiceDao;
//import park.service.entity.Camper;
//import park.service.entity.ParkRanger;
//import park.service.entity.ParkService;
//
//@Service 
//public class ParkRangerService {
//	  @Autowired 
//	  private ParkRangerDao parkRangerDao;
//	  @Autowired 
//	  private ParkServiceDao parkServiceDao;
//		
//		  @Transactional(readOnly = false)
//		  public ParkServiceParkRanger saveParkRanger(Long parkServiceId, ParkServiceParkRanger
//		  parkServiceParkRanger) { 
//		  ParkService parkService = findParkServicebyId(parkServiceId); 
//		  Long parkRangerId = parkServiceParkRanger.getParkRangerId(); 
//		  ParkRanger parkRanger = findOrCreateParkRanger(parkServiceId, parkRangerId);
//		  
//		  copyParkRangerFields(parkRanger, parkServiceParkRanger);
//		  
//		  parkRanger.setParkService(parkService);
//		  parkService.getParkRangers().add(parkRanger);
//		  
//		  ParkRanger dbParkRanger = parkRangerDao.save(parkRanger);
//		  
//		  return new ParkServiceParkRanger(dbParkRanger); }
//		 
//	  
//		
//		  private ParkRanger findOrCreateParkRanger(Long parkServiceId, Long
//		  parkRangerId) {
//		  
//		  if(Objects.isNull(parkRangerId)) { return new ParkRanger(); } return
//		  findParkRangerbyId(parkServiceId, parkRangerId); }
//		  
//		  private void copyParkRangerFields(ParkRanger parkRanger,
//		  ParkServiceParkRanger parkServiceParkRanger) {
//		  parkRanger.setParkRangerFirstName(parkServiceParkRanger.
//		  getParkRangerFirstName());
//		  parkRanger.setParkRangerLastName(parkServiceParkRanger.getParkRangerLastName(
//		  ));
//		  parkRanger.setParkRangerPhone(parkServiceParkRanger.getParkRangerPhone());
//		  parkRanger.setParkRangerJobTitle(parkServiceParkRanger.getParkRangerJobTitle(
//		  ));
//		  
//		  }
//		  
//		  private ParkService findParkServicebyId(Long parkServiceId) { return
//		  parkServiceDao.findById(parkServiceId).orElseThrow(() -> new
//		  NoSuchElementException("ParkService with ID=" + parkServiceId +
//		  " was not found.")); }
//		 
//	  
//	  @Transactional(readOnly = true) public 
//	  ParkRangerData retrieveParkRangerById(Long parkServiceId, Long parkRangerId) { ParkRanger
//	  parkRanger = findParkRangerbyId(parkServiceId, parkRangerId);
//	  
//	  
//	  return new ParkRangerData(parkRanger); 
//	  }
//	  
//	  
//	 // private ParkRanger findParkRangerById(Long parkServiceId, Long parkRangerId) { 
//	// ParkRanger parkRanger = parkRangerDao.findById(parkRangerId).orElseThrow(()
//	// -> new NoSuchElementException ("ParkRanger with ID=" + parkRangerId +
//	 // " was not found.")); 
//	// if(parkRanger.getParkService().getParkServiceId() !=parkServiceId) { 
//	// throw new IllegalArgumentException("The park ranger with ID=" + parkRangerId +
//	 // " is not employed by the ParkService with ID=" + parkServiceId + "."); 
//	 // }
//	//  return parkRanger; 
//	//  }
//	  private ParkRanger findParkRangerbyId(Long parkServiceId, Long parkRangerId) {
//			return parkRangerDao.findById(parkServiceId).orElseThrow(() -> new NoSuchElementException("ParkRanger with ID=" + parkRangerId + 
//					" is not employed by the ParkService with ID=" + parkServiceId + "."));
//		}
//	  
//	  @Transactional(readOnly = true) public List<ParkRangerData>
//	  retrieveAllParkRangers() { List<ParkRanger> parkRangers =
//	  parkRangerDao.findAll(); List<ParkRangerData> result = new LinkedList<>();
//	  
//	  for(ParkRanger parkRanger : parkRangers) { ParkRangerData psd = new
//	  ParkRangerData(parkRanger); result.add(psd); } return result; }
//	  
//	  public void deleteParkRangerById(Long parkServiceId, Long parkRangerId) {
//	  ParkRanger parkRanger = findParkRangerbyId(parkServiceId, parkRangerId);
//	  parkRangerDao.delete(parkRanger);
//	  
//	  }
//
//	 
//	  }
//	 

