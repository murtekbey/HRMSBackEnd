package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface EmployerJobAdvertisementService {
	Result add(EmployerJobAdvertisement employerJobAdvertisement);
	DataResult<List<JobAdvertisementWithEmployerDto>> getDetails();
	DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByReleaseDate(Date releaseDate);
	DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByApplicationDeadline(LocalDate applicationDeadline);
	DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByEmployer(int employerId);
	
	Result makePassiveJobAdvertisementByEmployer(EmployerJobAdvertisement employerJobAdvertisement);
	Result makeActiveJobAdvertisementByEmployer(EmployerJobAdvertisement employerJobAdvertisement);
}
