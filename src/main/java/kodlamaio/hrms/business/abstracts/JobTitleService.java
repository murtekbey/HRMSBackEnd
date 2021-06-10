package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	Result add(JobTitle jobTitle);
	Result update(JobTitle jobTitle);
	Result delete(JobTitle jobTitle);
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> getByTitle(String title);
}
