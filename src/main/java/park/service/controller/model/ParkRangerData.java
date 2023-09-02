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



