package park.service.controller.model;

import java.util.HashSet;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import park.service.controller.model.CamperData;
import park.service.entities.Camper;
import park.service.entities.ParkRanger;
import park.service.entities.ParkService;


@Data
@NoArgsConstructor
public class CamperData {
	private Long camperId;
	private String camperFirstName;
	private String camperLastName;
	private String camperEmail;
	
	private Set<ParkRangerData> parkRangers = new HashSet<> ();

	public CamperData(Camper camper) {
		camperId = camper.getCamperId();
		camperFirstName = camper.getCamperFirstName();
		camperLastName = camper.getCamperLastName();
		camperEmail = camper.getCamperEmail();
		
			
	}
//
//	@Data
//	@NoArgsConstructor
//	public
//	static class CamperParkRanger {
//		private Long parkRangerId;
//		private String parkRangerFirstName;
//		private String parkRangerLastName;
//		private Long parkRangerPhone;
//		private String parkRangerJobTitle;
//		
//		public CamperParkRanger(ParkRanger parkRanger) {
//			parkRangerId = parkRanger.getParkRangerId();
//			parkRangerFirstName = parkRanger.getParkRangerFirstName();
//			parkRangerLastName = parkRanger.getParkRangerLastName();
//			parkRangerPhone = parkRanger.getParkRangerPhone();
//			parkRangerJobTitle = parkRanger.getParkRangerJobTitle();		
//				
//		}
//		
//		@Data
//		@NoArgsConstructor
//		public class CamperParkService {
//
//			private Long parkServiceId;
//			private String parkServiceName;
//			private String parkServiceAddress;
//			private String parkServiceCity;
//			private String parkServiceState;
//			private Long parkServiceZip;
//			private Long parkServicePhone;
//			private String parkServiceCurrentEvents;
//						
//			
//			public CamperParkService(ParkService parkService) {
//				parkServiceId = parkService.getParkServiceId();
//				parkServiceName = parkService.getParkServiceName();
//				parkServiceAddress = parkService.getParkServiceAddress();
//				parkServiceCity =parkService.getParkServiceCity();
//				parkServiceState = parkService.getParkServiceState();
//				parkServiceZip = parkService.getParkServiceZip();
//				parkServicePhone = parkService.getParkServicePhone();
//				parkServiceCurrentEvents = parkService.getParkServiceCurrentEvents();
//					
//		}
//	}
//}

	
}


	


