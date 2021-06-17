package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService {
	
	private EmployeeConfirmEmployerDao employeeConfirmEmployerDao;
	

	@Autowired
	public EmployeeConfirmEmployerManager(EmployeeConfirmEmployerDao employeeConfirmEmployerDao) {
		super();
		this.employeeConfirmEmployerDao = employeeConfirmEmployerDao;
	}


	@Override
	public Result confirmUser(EmployeeConfirmEmployer employeeConfirmEmployer) {
		this.employeeConfirmEmployerDao.save(employeeConfirmEmployer);
		return new SuccessResult("Kullanıcı onaylandı");
	}

}
