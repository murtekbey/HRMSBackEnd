package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.verificationCodeService.VerificationCodeGeneratorService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService {

	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	private VerificationCodeGeneratorService verificationCodeGeneratorService;
	
	@Autowired
	public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao,
			VerificationCodeGeneratorService verificationCodeGeneratorService) {
		super();
		this.verificationCodeCandidateDao = verificationCodeCandidateDao;
		this.verificationCodeGeneratorService = verificationCodeGeneratorService;
	}

	@Override
	public Result generateCandidateCode(Candidate candidate) {
		VerificationCodeCandidate candidateCode = new VerificationCodeCandidate();
		candidateCode.setCode(this.verificationCodeGeneratorService.generateVerificationCode());
		candidateCode.setVerified(false);
		candidateCode.setCandidate(candidate);
		
		this.verificationCodeCandidateDao.save(candidateCode);
		
		return new SuccessResult("Verification Code is created.");
	}

}
