package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.abstracts.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.CandidateService;
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
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
	}

	@Override
	public Result add(Candidate candidate) {
		if(!candidateCheckService.checkIfRealPerson(candidate)){
			return new ErrorResult("Not a valid person");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi: " + candidate.getEmail());
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
