package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface VerificationCodeCandidateService {
	Result generateCandidateCode(Candidate candidate);
}
