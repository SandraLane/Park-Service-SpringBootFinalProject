package park.service.controller.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import park.service.controller.model.ParkServiceData;
import park.service.entity.Camper;
import park.service.entity.ParkRanger;
import park.service.entity.ParkService;

@Data
@NoArgsConstructor
public class ParkServiceData {
	private Long parkServiceId;
	private String parkServiceName;
	private String parkServiceAddress;
	private String parkServiceCity;
	private String parkServiceState;
	private Long parkServiceZip;
	private Long parkServicePhone;
	private String parkServiceCurrentEvents;
	
	private Set<ParkServiceParkRanger> parkRangers = new HashSet<> ();
	private Set<ParkServiceCamper> campers = new HashSet<> ();	
	
	
	
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
			campers.add(new ParkServiceCamper(camper));
		}
		for (ParkRanger parkRanger : parkService.getParkRangers()) {
			parkRangers.add(new ParkServiceParkRanger(parkRanger));
			}
	}


	@Data
	@NoArgsConstructor
	public
	
	static class ParkServiceCamper {
		private Long camperId;
		private String camperFirstName;
		private String camperLastName;
		private String camperEmail;
		
		public ParkServiceCamper(Camper camper) {
			camperId = camper.getCamperId();
			camperFirstName = camper.getCamperFirstName();
			camperLastName = camper.getCamperLastName();
			camperEmail = camper.getCamperEmail();
		}
	}
		
	@Data
	@NoArgsConstructor
	public
	static class ParkServiceParkRanger {
		private Long parkRangerId;
		private String parkRangerFirstName;
		private String parkRangerLastName;
		private Long parkRangerPhone;
		private String parkRangerJobTitle;
		
		public ParkServiceParkRanger(ParkRanger parkRanger) {
			parkRangerId = parkRanger.getParkRangerId();
			parkRangerFirstName = parkRanger.getParkRangerFirstName();
			parkRangerLastName = parkRanger.getParkRangerLastName();
			parkRangerPhone = parkRanger.getParkRangerPhone();
			parkRangerJobTitle = parkRanger.getParkRangerJobTitle();	
			
		
				
		}
	

		
	}


}


