package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(jobTitleDao.getByTitle(jobTitle.getTitle()) != null) {
			return new ErrorResult("Job title already exists.");
		}
		
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi: " + jobTitle.getTitle());
	}

	@Override
	public Result update(JobTitle jobTitle) {
		if(jobTitleDao.getByTitle(jobTitle.getTitle()) != null) {
			return new ErrorResult("Job title already exists.");
		}
		
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu güncellendi: " + jobTitle.getTitle());
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult("İş pozisyonu silindi: " + jobTitle.getTitle());
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "İş pozisyonları getirildi");
	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getByTitle(title), "Title'a göre iş pozisyonu getirildi");
	}

}
