package park.service.entities;

import java.util.HashSet;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Camper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long camperId;		
	private String camperFirstName;
	private String camperLastName;
	private String camperEmail;
		
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy="campers", cascade = CascadeType.PERSIST)
	private Set<ParkService> parkServices = new HashSet<> ();
		
}

