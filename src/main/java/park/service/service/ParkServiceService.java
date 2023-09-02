package park.service.service;

import java.util.LinkedList;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import park.service.controller.model.CamperData;
import park.service.controller.model.ParkRangerData;
import park.service.controller.model.ParkServiceData;
import park.service.dao.CamperDao;
import park.service.dao.ParkRangerDao;
import park.service.dao.ParkServiceDao;
import park.service.entities.Camper;
import park.service.entities.ParkRanger;
import park.service.entities.ParkService;

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
		parkService.setParkServiceId(parkServiceData.getParkServiceId());
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
	  
	  private ParkRanger findParkRangerbyId(Long parkServiceId, Long parkRangerId) {
		return parkRangerDao.findById(parkServiceId).orElseThrow(() -> new NoSuchElementException("ParkRanger with ID=" + parkRangerId + 
				" is not employed by the ParkService with ID=" + parkServiceId + "."));
	}
	  
	  private Camper findCamperById(Long parkServiceId, Long camperId) { 
	  Camper camper = camperDao.findById(camperId).orElseThrow(() -> new
		  NoSuchElementException("Camper with ID=" + camperId + "was not found."));
		  
	  boolean found = false;
	  
	  for(ParkService parkService : camper.getParkServices()) {
	  if(parkService.getParkServiceId() == parkServiceId) { 
		  found = true; 
		  break; 
	  }
		  } if(!found) { 
		  throw new IllegalArgumentException("The camper with ID=" +
	  camperId + " is not a member of the park with ID=" + parkServiceId); 
		  } 
		  return camper; 
	  }
	    
		  @Transactional(readOnly = false) 
		  public ParkRangerData saveParkRanger(Long parkServiceId, ParkRangerData
		  parkRangerData) { 
		  ParkService parkService = findParkServicebyId(parkServiceId); 
		  Long parkRangerId = parkRangerData.getParkRangerId(); 
		  ParkRanger parkRanger = findOrCreateParkRanger(parkServiceId, parkRangerId);
		  
		  copyParkRangerFields(parkRanger, parkRangerData);
		  
		  parkRanger.setParkService(parkService);
		  parkService.getParkRangers().add(parkRanger);
		  
		  ParkRanger dbParkRanger = parkRangerDao.save(parkRanger);
		  
		  return new ParkRangerData(dbParkRanger); 
		  }
		  
		  @Transactional(readOnly = false) 
		  public CamperData saveCamper(Long parkServiceId, CamperData camperData) { 
		  ParkService parkService = findParkServicebyId(parkServiceId); 
		  Long camperId = camperData.getCamperId(); 
		  Camper camper = findOrCreateCamper(parkServiceId, camperId);
		  
		  copyCamperFields(camper, camperData);
		  
		  camper.getParkServices().add(parkService);
		  parkService.getCampers().add(camper);
		  
		  Camper dbCamper = camperDao.save(camper);
		  
		  return new CamperData(dbCamper); 
		  }
		  
		  
		  private void copyParkRangerFields(ParkRanger parkRanger, ParkRangerData parkRangerData) {
		  parkRanger.setParkRangerId(parkRangerData.getParkRangerId());
		  parkRanger.setParkRangerFirstName(parkRangerData.getParkRangerFirstName());
		  parkRanger.setParkRangerLastName(parkRangerData.getParkRangerLastName());
		  parkRanger.setParkRangerPhone(parkRangerData.getParkRangerPhone());
		  parkRanger.setParkRangerJobTitle(parkRangerData.getParkRangerJobTitle());
		  
		  }
		  
		  
		  private void copyCamperFields(Camper camper, CamperData
		  camperData) {
		  camper.setCamperId(camperData.getCamperId());
		  camper.setCamperFirstName(camperData.getCamperFirstName());
		  camper.setCamperLastName(camperData.getCamperLastName());
		  camper.setCamperEmail(camperData.getCamperEmail()); 
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
	  parkRanger = findParkRangerById(parkServiceId, parkRangerId);
	  
	  
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
	  ParkRanger parkRanger = findParkRangerById(parkServiceId, parkRangerId);
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


