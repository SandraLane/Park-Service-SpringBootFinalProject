//package park.service.service;
//
//import java.util.LinkedList;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import park.service.controller.model.CamperData;
//import park.service.controller.model.ParkRangerData;
//import park.service.controller.model.ParkServiceData;
//import park.service.controller.model.ParkServiceData.ParkServiceCamper;
//import park.service.dao.CamperDao;
//import park.service.dao.ParkServiceDao;
//import park.service.entity.Camper;
//import park.service.entity.ParkRanger;
//import park.service.entity.ParkService;
//
//@Service
//public class CamperService {
//	@Autowired
//	private static CamperDao camperDao;
//	@Autowired 
//	private ParkServiceDao parkServiceDao;
//	
//	 @Transactional(readOnly = false) 
//	  public ParkServiceCamper saveCamper(Long parkServiceId, ParkServiceCamper parkServiceCamper) { 
//	  ParkService parkService = findParkServicebyId(parkServiceId); 
//	  Long camperId = parkServiceCamper.getCamperId(); 
//	  Camper camper = findOrCreateCamper(parkServiceId, camperId);
//	  
//	  copyCamperFields(camper, parkServiceCamper);
//	  
//	  camper.getParkServices().add(parkService);
//	  parkService.getCampers().add(camper);
//	  
//	  Camper dbCamper = camperDao.save(camper);
//	  
//	  return new ParkServiceCamper(dbCamper); 
//	  }
//	 
//	 private ParkService findParkServicebyId(Long parkServiceId) { 
//		 return parkServiceDao.findById(parkServiceId).orElseThrow(() -> new
//			  NoSuchElementException("ParkService with ID=" + parkServiceId + " was not found.")); 
//	 }
//	 
//	 private Camper findOrCreateCamper(Long parkServiceId, Long camperId) {
//		  
//		  if(Objects.isNull(camperId)) { 
//		  return new Camper(); 
//		  } 
//		  return findCamperById(parkServiceId, camperId); 
//		  }
//	 
//		
//	 private static Camper findCamperById(Long parkServiceId, Long camperId) { 
//		  Camper camper = camperDao.findById(camperId).orElseThrow(() -> new
//		  NoSuchElementException("Camper with ID=" + camperId + "was not found."));
//		  
//		  boolean found = false;
//		  
//		  for(ParkService parkService : camper.getParkServices()) {
//		  if(parkService.getParkServiceId() == parkServiceId) { 
//			  found = true; 
//			  break; 
//		  }
//		  } if(!found) { 
//			  throw new IllegalArgumentException("The camper with ID=" +
//		  camperId + " is not a member of the park with ID=" + parkServiceId); 
//			  } 
//		  return camper; 
//		  }
//	 
//	 private void copyCamperFields(Camper camper, ParkServiceCamper
//			  parkServiceCamper) {
//			  camper.setCamperFirstName(parkServiceCamper.getCamperFirstName());
//			  camper.setCamperLastName(parkServiceCamper.getCamperLastName());
//			  camper.setCamperEmail(parkServiceCamper.getCamperEmail()); 
//			  }
//	  
//								
//				  
//		@Transactional(readOnly = true)
//		public CamperData retrieveCamperById(Long parkServiceId, Long camperId) {
//		Camper camper = findCamperById(parkServiceId, camperId);
//					
//					
//			return new CamperData(camper);
//		}
//		
//	 
//	 @Transactional(readOnly=true)
//	public List<CamperData> retrieveAllCampers() {
//		List<Camper> campers = camperDao.findAll();
//		List<CamperData> result = new LinkedList<>();
//		
//		for(Camper camper : campers) {
//			CamperData psd = new CamperData(camper);
//			result.add(psd);
//		}
//		return result;
//	}
//	
//	public void deleteCamperById(Long parkServiceId, Long camperId) {
//		Camper camper = findCamperById(parkServiceId, camperId);
//		camperDao.delete(camper);
//		
//	}
//
//		
//	
//}
//
// 
 

