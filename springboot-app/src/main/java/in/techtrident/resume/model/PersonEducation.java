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
@Table(name = "personeducation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String studyAt;
	
	private String percentage;
	
	private String startAt;
	
	private String endAt;
	
	

}
