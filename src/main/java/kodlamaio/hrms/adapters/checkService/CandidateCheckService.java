package kodlamaio.hrms.adapters.checkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	Result checkIfRealPerson(Candidate candidate);
}
