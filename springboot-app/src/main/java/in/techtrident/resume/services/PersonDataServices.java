package in.techtrident.resume.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.techtrident.resume.model.PersonDataModel;
import in.techtrident.resume.repo.ResumeRepository;

@Service
public class PersonDataServices {
	
	@Autowired
	private ResumeRepository repo;
	
	public PersonDataModel saveDataModel(PersonDataModel model) {
		
		return repo.save(model);
		
	}
	
	public List<PersonDataModel> getDataMOdel() {
		return repo.findAll();
	}

}
