package park.service.service;

import java.util.LinkedList;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import park.service.controller.model.ParkServiceData.ParkServiceCamper;
import park.service.controller.model.ParkServiceData.ParkServiceParkRanger;
import park.service.controller.model.CamperData;
import park.service.controller.model.ParkRangerData;
import park.service.controller.model.ParkServiceData;
import park.service.dao.CamperDao;
import park.service.dao.ParkRangerDao;
import park.service.dao.ParkServiceDao;
import park.service.entity.Camper;
import park.service.entity.ParkRanger;
import park.service.entity.ParkService;

@Service
public class ParkServiceService {
	@Autowired
	private ParkServiceDao parkServiceDao;
	@Autowired
	private ParkRangerDao parkRangerDao;
	@Autowired
	private CamperDao camperDao;
	
	@Transactional(readOnly = false)
	public ParkServiceData saveParkService(ParkServiceData parkServiceData) {
		Long parkServiceId = parkServiceData.getParkServiceId();
		ParkService parkService = findOrCreateParkService(parkServiceId);
		
		copyParkServiceFields(parkService, parkServiceData);
		return new ParkServiceData(parkServiceDao.save(parkService));
	}
		

	private void copyParkServiceFields(ParkService parkService, ParkServiceData parkServiceData) {
		parkService.setParkServiceName(parkServiceData.getParkServiceName());
		parkService.setParkServiceAddress(parkServiceData.getParkServiceAddress());
		parkService.setParkServiceCity(parkServiceData.getParkServiceCity());
		parkService.setParkServiceState(parkServiceData.getParkServiceState());
		parkService.setParkServiceZip(parkServiceData.getParkServiceZip());
		parkService.setParkServicePhone(parkServiceData.getParkServicePhone());
		parkService.setParkServiceCurrentEvents(parkServiceData.getParkServiceCurrentEvents());
		
	}

	private ParkService findOrCreateParkService(Long parkServiceId) {
		ParkService parkService;
		
		if(Objects.isNull(parkServiceId)) {
			
			parkService = new ParkService();
		}
		else {
			parkService = findParkServicebyId(parkServiceId);
		}
		return parkService;
		
	}
	
	  private ParkRanger findOrCreateParkRanger(Long parkServiceId, Long
	  parkRangerId) {
	  
	  if(Objects.isNull(parkRangerId)) { 
	  return new ParkRanger(); 
	  } 
	  return findParkRangerById(parkServiceId, parkRangerId); 
	  }
	  
	  
	  private Camper findOrCreateCamper(Long parkServiceId, Long camperId) {
	  
	  if(Objects.isNull(camperId)) { 
	  return new Camper(); 
	  } 
	  return findCamperById(parkServiceId, camperId); 
	  }

	private ParkService findParkServicebyId(Long parkServiceId) {
		return parkServiceDao.findById(parkServiceId).orElseThrow(() -> new NoSuchElementException("ParkService with ID=" + parkServiceId + " was not found."));
	}

	
	  private ParkRanger findParkRangerById(Long parkServiceId, Long parkRangerId) { 
	  ParkRanger parkRanger = parkRangerDao.findById(parkRangerId).orElseThrow(()
	  -> new NoSuchElementException ("ParkRanger with ID=" + parkRangerId +
	  " was not found.")); 
	  if(parkRanger.getParkService().getParkServiceId() !=
	  parkServiceId) { 
	  throw new IllegalArgumentException("The park ranger with ID=" + parkRangerId +
	  " is not employed by the ParkService with ID=" + parkServiceId + "."); 
	  }
	  return parkRanger; 
	  }
	  
//	  private Camper findCamperById(Long parkServiceId, Long camperId) { 
//	  Camper camper = camperDao.findById(camperId).orElseThrow(() -> new
//		  NoSuchElementException("Camper with ID=" + camperId + "was not found."));
//		  
//	  boolean found = false;
//	  
//	  for(ParkService parkService : camper.getParkServices()) {
//	  if(parkService.getParkServiceId() == parkServiceId) { 
//		  found = true; 
//		  break; 
//	  }
//		  } if(!found) { 
//		  throw new IllegalArgumentException("The camper with ID=" +
//	  camperId + " is not a member of the park with ID=" + parkServiceId); 
//		  } 
//		  return camper; 
//	  }
	  
	  private Camper findCamperById(Long parkServiceId, Long camperId) { 
		  Camper camper = camperDao.findById(camperId).orElseThrow(()
		  -> new NoSuchElementException ("Camper with ID=" + camperId +
		  " was not found.")); 
		  if(camper.getParkService().getParkServiceId() !=
		  parkServiceId) { 
		  throw new IllegalArgumentException("The camper with ID=" + camperId +
		  " is not staying at the ParkService with ID=" + parkServiceId + "."); 
		  }
		  return camper; 
		  }
	  
	  private ParkRanger findParkRangerbyId(Long parkServiceId, Long parkRangerId) {
			return parkRangerDao.findById(parkServiceId).orElseThrow(() -> new NoSuchElementException("ParkRanger with ID=" + parkRangerId + 
					" is not employed by the ParkService with ID=" + parkServiceId + "."));
		}
	  
//	  private Camper findCamperbyId(Long parkServiceId, Long camperId) {
//			return camperDao.findById(parkServiceId).orElseThrow(() -> new NoSuchElementException("Camper with ID=" + camperId + 
//					" was not found by the ParkService with ID=" + parkServiceId + "."));
//		}
	  
	  
		  @Transactional(readOnly = false) 
		  public ParkServiceParkRanger saveParkRanger(Long parkServiceId, ParkServiceParkRanger
		  parkServiceParkRanger) { 
		  ParkService parkService = findParkServicebyId(parkServiceId); 
		  Long parkRangerId = parkServiceParkRanger.getParkRangerId(); 
		  ParkRanger parkRanger = findOrCreateParkRanger(parkServiceId, parkRangerId);
		  
		  copyParkRangerFields(parkRanger, parkServiceParkRanger);
		  
		  parkRanger.setParkService(parkService);
		  parkService.getParkRangers().add(parkRanger);
		  
		  ParkRanger dbParkRanger = parkRangerDao.save(parkRanger);
		  
		  return new ParkServiceParkRanger(dbParkRanger); 
		  }
		  
		  @Transactional(readOnly = false) 
		  public ParkServiceCamper saveCamper(Long parkServiceId, ParkServiceCamper parkServiceCamper) { 
		  ParkService parkService = findParkServicebyId(parkServiceId); 
		  Long camperId = parkServiceCamper.getCamperId(); 
		  Camper camper = findOrCreateCamper(parkServiceId, camperId);
		  
		  copyCamperFields(camper, parkServiceCamper);
		  
		  camper.getParkServices().add(parkService);
		  parkService.getCampers().add(camper);
		  
		  Camper dbCamper = camperDao.save(camper);
		  
		  return new ParkServiceCamper(dbCamper); 
		  }
		  
		  
		  private void copyParkRangerFields(ParkRanger parkRanger, ParkServiceParkRanger parkServiceParkRanger) {
		  parkRanger.setParkRangerFirstName(parkServiceParkRanger.getParkRangerFirstName());
		  parkRanger.setParkRangerLastName(parkServiceParkRanger.getParkRangerLastName());
		  parkRanger.setParkRangerPhone(parkServiceParkRanger.getParkRangerPhone());
		  parkRanger.setParkRangerJobTitle(parkServiceParkRanger.getParkRangerJobTitle());
		  
		  }
		  
		  
		  private void copyCamperFields(Camper camper, ParkServiceCamper
		  parkServiceCamper) {
		  camper.setCamperFirstName(parkServiceCamper.getCamperFirstName());
		  camper.setCamperLastName(parkServiceCamper.getCamperLastName());
		  camper.setCamperEmail(parkServiceCamper.getCamperEmail()); 
		  }
		  
		 
	  @Transactional(readOnly = true)
	  public ParkServiceData retrieveParkServiceById(Long parkServiceId) {
		ParkService parkService = findParkServicebyId(parkServiceId);
		
		
		return new ParkServiceData(parkService);
	}
	 
	  @Transactional
	  public List<ParkServiceData> retrieveAllParkServices() {
		List<ParkService> parkServices = parkServiceDao.findAll();
		List<ParkServiceData> result = new LinkedList<>();
		
		for(ParkService parkService : parkServices) {
			result.add(new ParkServiceData(parkService));
		}
		
		return result;
	}
	@Transactional(readOnly = false)
	public void deleteParkServiceById(Long parkServiceId) {
		ParkService parkService = findParkServicebyId(parkServiceId);
		parkServiceDao.delete(parkService);
		
	}
	 @Transactional(readOnly = true) public 
	  ParkRangerData retrieveParkRangerById(Long parkServiceId, Long parkRangerId) { ParkRanger
	  parkRanger = findParkRangerbyId(parkServiceId, parkRangerId);
	  
	  
	  return new ParkRangerData(parkRanger); 
	  }
	 
	  
	  @Transactional(readOnly = true) 
	  public List<ParkRangerData> retrieveAllParkRangers() { 
	  List<ParkRanger> parkRangers = parkRangerDao.findAll(); 
	  List<ParkRangerData> result = new LinkedList<>();	  
	  for(ParkRanger parkRanger : parkRangers) { 
	  ParkRangerData psd = new ParkRangerData(parkRanger); 
	  result.add(psd); 
	  } 
	  return result; 
	  }
	  
	  public void deleteParkRangerById(Long parkServiceId, Long parkRangerId) {
	  ParkRanger parkRanger = findParkRangerbyId(parkServiceId, parkRangerId);
	  parkRangerDao.delete(parkRanger);
	  
	  }
	  @Transactional(readOnly = true)
		public CamperData retrieveCamperById(Long parkServiceId, Long camperId) {
		Camper camper = findCamperById(parkServiceId, camperId);
					
					
			return new CamperData(camper);
		}
		
	 
	 @Transactional(readOnly=true)
	public List<CamperData> retrieveAllCampers() {
		List<Camper> campers = camperDao.findAll();
		List<CamperData> result = new LinkedList<>();
		
		for(Camper camper : campers) {
			CamperData psd = new CamperData(camper);
			result.add(psd);
		}
		return result;
	}
	
	public void deleteCamperById(Long parkServiceId, Long camperId) {
		Camper camper = findCamperById(parkServiceId, camperId);
		camperDao.delete(camper);
		
	}


	
	

}


