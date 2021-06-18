package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateResume;

@RestController
@RequestMapping("/api/candidateResumes")
public class CandidateResumesController {

	private CandidateResumeService candidateResumeService;

	@Autowired
	public CandidateResumesController(CandidateResumeService candidateResumeService) {
		super();
		this.candidateResumeService = candidateResumeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateResume candidateResume) {
		return this.candidateResumeService.add(candidateResume);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CandidateResume> getByCandidateId(int candidateId) {
		return this.candidateResumeService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateResume>> getAll() {
		return this.candidateResumeService.getAll();
	}
}
