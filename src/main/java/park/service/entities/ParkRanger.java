package park.service.entities;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class ParkRanger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long parkRangerId;
	
	private String parkRangerFirstName;
	private String parkRangerLastName;
	private String parkRangerPhone;
	private String parkRangerJobTitle;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="park_service_id")
	private ParkService parkService;
}
