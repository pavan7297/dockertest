package in.techtrident.resume.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String full_name;
	
	private String phone;
	
	private String email;
	
	private String linkdin;
	
	private String git;
	
	private String summary;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PersonExperience> experience;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PersonEducation> education;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PersonProjects> projects;
	
}
