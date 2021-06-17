package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.checkService.CandidateCheckService;
import kodlamaio.hrms.adapters.mailConfirmationService.MailConfirmationService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private MailConfirmationService mailConfirmationService;
	private VerificationCodeCandidateService verificationCodeCandidateService;
	
	@Autowired
	public CandidateManager(
			CandidateDao candidateDao,
			CandidateCheckService candidateCheckService,
			MailConfirmationService mailConfirmationService,
			VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.mailConfirmationService = mailConfirmationService;
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}

	@Override
	public Result add(Candidate candidate) {
		
		Result checkPerson = candidateCheckService.checkIfRealPerson(candidate);
		if(!checkPerson.isSuccess()){
			return new ErrorResult(checkPerson.getMesssage());
		}
		
		Result mailConfirmation = mailConfirmationService.confirmUser(candidate);
		if (!mailConfirmation.isSuccess()) {
			return new ErrorResult(mailConfirmation.getMesssage());
		}
		
		if (this.candidateDao.findByEmail(candidate.getEmail()) != null) {
			return new ErrorResult("Email already exists");
		}
		
		if (this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()) != null) {
			return new ErrorResult("Identity number already exists");
		}
		
		this.candidateDao.save(candidate);
		this.verificationCodeCandidateService.generateCandidateCode(candidate);
		return new SuccessResult("Aday eklendi: " + "Doğrulama kodu gönderildi");
	}

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday güncellendi: " + candidate.getEmail());
	}

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("Aday silindi: " + candidate.getEmail());
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar listelendi");
	}

	@Override
	public DataResult<Candidate> findByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email), "Aday maile göre getirildi");
	}

	@Override
	public DataResult<Candidate> findByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentityNumber(identityNumber), "Aday kimlik numarasına göre getirildi");
	}

}
