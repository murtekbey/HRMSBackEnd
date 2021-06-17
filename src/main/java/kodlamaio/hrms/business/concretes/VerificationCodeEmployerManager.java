package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.verificationCodeService.VerificationCodeGeneratorService;
import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService {

	private VerificationCodeEmployerDao verificationCodeEmployerDao;
	private VerificationCodeGeneratorService verificationCodeGeneratorService;
	
	@Autowired
	public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao,
			VerificationCodeGeneratorService verificationCodeGeneratorService) {
		super();
		this.verificationCodeEmployerDao = verificationCodeEmployerDao;
		this.verificationCodeGeneratorService = verificationCodeGeneratorService;
	}

	@Override
	public Result generateEmployerCode(Employer employer) {
		VerificationCodeEmployer employerCode = new VerificationCodeEmployer();
		employerCode.setCode(this.verificationCodeGeneratorService.generateVerificationCode());
		employerCode.setVerified(false);
		employerCode.setEmployer(employer);
		
		this.verificationCodeEmployerDao.save(employerCode);
		return new SuccessResult("Verification Code is created.");
	}

}
