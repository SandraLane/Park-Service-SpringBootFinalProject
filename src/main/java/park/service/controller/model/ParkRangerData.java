package park.service.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import park.service.controller.model.ParkRangerData;
import park.service.entities.Camper;
import park.service.entities.ParkRanger;
import park.service.entities.ParkService;


@Data
@NoArgsConstructor
public class ParkRangerData {
	private Long parkRangerId;	
	private String parkRangerFirstName;
	private String parkRangerLastName;
	private String parkRangerPhone;
	private String parkRangerJobTitle;
	
	private Set<CamperData> campers = new HashSet<> ();	

	
	public ParkRangerData(ParkRanger parkRanger) {
		parkRangerId = parkRanger.getParkRangerId();
		parkRangerFirstName = parkRanger.getParkRangerFirstName();
		parkRangerLastName = parkRanger.getParkRangerLastName();
		parkRangerPhone = parkRanger.getParkRangerPhone();
		parkRangerJobTitle = parkRanger.getParkRangerJobTitle();
		
	}
}
//
//@Data
//@NoArgsConstructor
//public
//static class ParkRangerCamper {
//	private Long camperId;
//	private String camperFirstName;
//	private String camperLastName;
//	private String camperEmail;
//	
//	public ParkRangerCamper(Camper camper) {
//		camperId = camper.getCamperId();
//		camperFirstName = camper.getCamperFirstName();
//		camperLastName = camper.getCamperLastName();
//		camperEmail = camper.getCamperEmail();
//	}
//	
//	@Data
//	@NoArgsConstructor
//	public class ParkRangerParkService {
//
//		private Long parkServiceId;
//		private String parkServiceName;
//		private String parkServiceAddress;
//		private String parkServiceCity;
//		private String parkServiceState;
//		private Long parkServiceZip;
//		private String parkServicePhone;
//		private String parkServiceCurrentEvents;
//		
//		
//		public ParkRangerParkService(ParkService parkService) {
//			parkServiceId = parkService.getParkServiceId();
//			parkServiceName = parkService.getParkServiceName();
//			parkServiceAddress = parkService.getParkServiceAddress();
//			parkServiceCity =parkService.getParkServiceCity();
//			parkServiceState = parkService.getParkServiceState();
//			parkServiceZip = parkService.getParkServiceZip();
//			parkServicePhone = parkService.getParkServicePhone();
//			parkServiceCurrentEvents = parkService.getParkServiceCurrentEvents();
//			
//			
//		
//		}
//	}
//}
//}


