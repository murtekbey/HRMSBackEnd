package kodlamaio.hrms.api.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerJobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@RestController
@RequestMapping("/api/employerJobAdvertisements")
public class EmployerJobAdvertisementsController {

	private EmployerJobAdvertisementService employerJobAdvertisementService;

	@Autowired
	public EmployerJobAdvertisementsController(EmployerJobAdvertisementService employerJobAdvertisementService) {
		super();
		this.employerJobAdvertisementService = employerJobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerJobAdvertisement employerJobAdvertisement) {
		return this.employerJobAdvertisementService.add(employerJobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetails() {
		return this.employerJobAdvertisementService.getDetails();
	}
	
	@GetMapping("/getAllByReleaseDate")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByReleaseDate(@RequestParam String releaseDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return this.employerJobAdvertisementService.getDetailsByReleaseDate(sdf.parse(releaseDate));
	}
	
	@GetMapping("/getAllByApplicationDeadline")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByApplicationDeadline(@RequestParam String applicationDeadline) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return this.employerJobAdvertisementService.getDetailsByApplicationDeadline(LocalDate.parse(applicationDeadline, fmt));
	}
	
	@GetMapping("/getAllByEmployer")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByEmployer(@RequestParam int employerId) {
		return this.employerJobAdvertisementService.getDetailsByEmployer(employerId);
	}
	
	@PostMapping("/makeJobPassive")
	public Result makePassiveJobAdvertisementByEmployer(@RequestBody EmployerJobAdvertisement employerJobAdvertisement) {
		return this.employerJobAdvertisementService.makePassiveJobAdvertisementByEmployer(employerJobAdvertisement);
	}
	
	@PostMapping("/makeJobActive")
	public Result makeActiveJobAdvertisementByEmployer(@RequestBody EmployerJobAdvertisement employerJobAdvertisement) {
		return this.employerJobAdvertisementService.makeActiveJobAdvertisementByEmployer(employerJobAdvertisement);		
	}
}
