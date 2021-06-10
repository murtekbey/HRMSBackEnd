package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
@CrossOrigin
public class JobTitlesController {

	private JobTitleService jobTitleService;

	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("add")
	public Result add(JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@PostMapping("update")
	public Result update(JobTitle jobTitle) {
		return this.jobTitleService.update(jobTitle);
	}
	
	@PostMapping("delete")
	public Result delete(JobTitle jobTitle) {
		return this.jobTitleService.delete(jobTitle);
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("getByTitle")
	public DataResult<JobTitle> getByTitle(String title) {
		return this.jobTitleService.getByTitle(title);
	}
}
