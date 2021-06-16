package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	Result update(Employer employer);
	Result delete(Employer employer);
	DataResult<List<Employer>> getAll();
	DataResult<Employer> findByEmail(String email);
	DataResult<Employer> findByCompanyName(String companyName);
	DataResult<Employer> findByWebAddress(String webAddress);
}