package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateResume;

public interface CandidateResumeService {
	Result add(CandidateResume candidateResume);
	DataResult<CandidateResume> getByCandidateId(int candidateId);
	DataResult<List<CandidateResume>> getAll();
}
