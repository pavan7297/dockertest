package in.techtrident.resume.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.techtrident.resume.model.PersonDataModel;
import in.techtrident.resume.repo.ResumeRepository;
import in.techtrident.resume.services.PersonDataServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeController {

//	@GetMapping
//	public String getMethodName() {
//		return new String("pavan");
//	}

	@Autowired
	private PersonDataServices services;

	@GetMapping
	public ResponseEntity<?> getMethodName() {

		try {

			List<PersonDataModel> all = services.getDataMOdel();

			return ResponseEntity.ok().body(all);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e);
		}
//		return new String();
	}

	@PostMapping
	public ResponseEntity<?> personData(@RequestBody PersonDataModel model) {
		try {

			System.err.println("data model:::::::::::" + model);
			PersonDataModel out = services.saveDataModel(model);
			return ResponseEntity.accepted().body(out);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e);
		}
	}

}
