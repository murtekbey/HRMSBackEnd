package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.mailConfirmationService.MailConfirmationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private VerificationCodeEmployerService verificationCodeEmployerService;
	private MailConfirmationService mailConfirmationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,
			VerificationCodeEmployerService verificationCodeEmployerService,
			MailConfirmationService mailConfirmationService) {
		super();
		this.employerDao = employerDao;
		this.verificationCodeEmployerService = verificationCodeEmployerService;
		this.mailConfirmationService = mailConfirmationService;
	}

	@Override
	public Result add(Employer employer) {
		Result checkEmployer = this.checkMail(employer.getEmail(), employer.getWebAddress());
		if (!checkEmployer.isSuccess()) {
			return new ErrorResult(checkEmployer.getMesssage());
		}
		
		Result mailConfirmation = mailConfirmationService.confirmUser(employer);
		if (!mailConfirmation.isSuccess()) {
			return new ErrorResult(mailConfirmation.getMesssage());
		}
		
		if (this.employerDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("Email already exists");
		}
		
		this.employerDao.save(employer);
		this.verificationCodeEmployerService.generateEmployerCode(employer);
		return new SuccessResult("İşveren eklendi: " + "Doğrulama kodu gönderildi");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren güncellendi: " + employer.getEmail());
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("İşveren silindi: " + employer.getEmail());
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşverenler getirildi");
	}

	@Override
	public DataResult<Employer> findByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email), "İşveren maille getirildi");
	}

	@Override
	public DataResult<Employer> findByCompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(companyName), "İşveren firma ismiyle getirildi");
	}

	@Override
	public DataResult<Employer> findByWebAddress(String webAddress) {
		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(webAddress), "İşveren web addresse göre getirildi");
	}

	private Result checkMail(String email, String webAddress) {
		
		String[] value1 = email.split("@");
		String[] value2 = webAddress.split("www.");
		
		if (value1[1].equals(value2[1])) {
			return new SuccessResult("Validate email and web address");
		}
		return new ErrorResult("Email and Web Address did not match");
	}
}
