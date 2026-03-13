package in.techtrident.resume.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personexperience")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String jobTitle;
	
	private String companyName;
	
	private String description;
	
	private String startDate;
	
	private String endDate;
	
	
	

}
