package park.service.controller.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import park.service.controller.model.ParkServiceData;
import park.service.entities.Camper;
import park.service.entities.ParkRanger;
import park.service.entities.ParkService;

@Data
@NoArgsConstructor
public class ParkServiceData {
	private Long parkServiceId;
	private String parkServiceName;
	private String parkServiceAddress;
	private String parkServiceCity;
	private String parkServiceState;
	private Long parkServiceZip;
	private String parkServicePhone;
	private String parkServiceCurrentEvents;
	
	private Set<ParkRangerData> parkRangers = new HashSet<> ();
	private Set<CamperData> campers = new HashSet<> ();	
	
	
	
	public ParkServiceData(ParkService parkService) {
		parkServiceId = parkService.getParkServiceId();
		parkServiceName = parkService.getParkServiceName();
		parkServiceAddress = parkService.getParkServiceAddress();
		parkServiceCity =parkService.getParkServiceCity();
		parkServiceState = parkService.getParkServiceState();
		parkServiceZip = parkService.getParkServiceZip();
		parkServicePhone = parkService.getParkServicePhone();
		parkServiceCurrentEvents = parkService.getParkServiceCurrentEvents();
		
		for(Camper camper : parkService.getCampers()) {
			campers.add(new CamperData(camper));
		}
		for (ParkRanger parkRanger : parkService.getParkRangers()) {
			parkRangers.add(new ParkRangerData(parkRanger));
			}
	}



}


