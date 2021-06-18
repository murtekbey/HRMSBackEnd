package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateResumeDao;
import kodlamaio.hrms.entities.concretes.CandidateResume;

@Service
public class CandidateResumeManager implements CandidateResumeService {

	private CandidateResumeDao candidateResumeDao;
	
	@Autowired
	public CandidateResumeManager(CandidateResumeDao candidateResumeDao) {
		super();
		this.candidateResumeDao = candidateResumeDao;
	}

	@Override
	public Result add(CandidateResume candidateResume) {
		this.candidateResumeDao.save(candidateResume);
		return new SuccessResult("CV Eklendi.");
	}

	@Override
	public DataResult<CandidateResume> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateResume>(this.candidateResumeDao.getByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<CandidateResume>> getAll() {
		return new SuccessDataResult<List<CandidateResume>>(this.candidateResumeDao.findAll());
	}

}
