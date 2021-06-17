package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerJobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerJobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.EmployerJobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@Service
public class EmployerJobAdvertisementManager implements EmployerJobAdvertisementService {

	private EmployerJobAdvertisementDao employerJobAdvertisementDao;
	
	@Autowired
	public EmployerJobAdvertisementManager(EmployerJobAdvertisementDao employerJobAdvertisementDao) {
		super();
		this.employerJobAdvertisementDao = employerJobAdvertisementDao;
	}

	@Override
	public Result add(EmployerJobAdvertisement employerJobAdvertisement) {
		this.employerJobAdvertisementDao.save(employerJobAdvertisement);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.employerJobAdvertisementDao.getDetails());
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByReleaseDate(Date releaseDate) {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.employerJobAdvertisementDao.getDetailsByReleaseDate(releaseDate));
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByApplicationDeadline(LocalDate applicationDeadline) {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.employerJobAdvertisementDao.getDetailsByApplicationDeadline(applicationDeadline));
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getDetailsByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.employerJobAdvertisementDao.getDetailsByEmployer(employerId));
	}

	@Override
	public Result makePassiveJobAdvertisementByEmployer(EmployerJobAdvertisement employerJobAdvertisement) {
		employerJobAdvertisement.setActive(false);
		this.employerJobAdvertisementDao.save(employerJobAdvertisement);
		return new SuccessResult("İş ilanı kapatıldı");
	}

	@Override
	public Result makeActiveJobAdvertisementByEmployer(EmployerJobAdvertisement employerJobAdvertisement) {
		employerJobAdvertisement.setActive(true);
		this.employerJobAdvertisementDao.save(employerJobAdvertisement);
		return new SuccessResult("İş ilanı açıldı");
	}

}
