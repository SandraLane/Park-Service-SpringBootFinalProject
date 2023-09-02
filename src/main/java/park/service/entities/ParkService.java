package park.service.entities;

import java.util.HashSet;


import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
public class ParkService {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long parkServiceId;
	@EqualsAndHashCode.Exclude
	private String parkServiceName;
	@EqualsAndHashCode.Exclude
	private String parkServiceAddress;
	@EqualsAndHashCode.Exclude
	private String parkServiceCity;
	@EqualsAndHashCode.Exclude
	private String parkServiceState;
	@EqualsAndHashCode.Exclude
	private Long parkServiceZip;
	@EqualsAndHashCode.Exclude
	private String parkServicePhone;
	@EqualsAndHashCode.Exclude
	private String parkServiceCurrentEvents;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany
	@JoinTable(name="park_camper",joinColumns= @JoinColumn(name="park_service_id"),
	inverseJoinColumns=@JoinColumn(name="camper_id"))		
	private Set<Camper> campers = new HashSet<> ();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "parkService", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ParkRanger> parkRangers = new HashSet<> ();

		

}

