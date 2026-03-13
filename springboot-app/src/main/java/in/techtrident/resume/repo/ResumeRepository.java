package in.techtrident.resume.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.techtrident.resume.model.PersonDataModel;

public interface ResumeRepository extends JpaRepository<PersonDataModel, String>{

}
