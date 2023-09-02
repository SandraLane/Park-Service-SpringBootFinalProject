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


	
}


	


