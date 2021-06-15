package kodlamaio.hrms.adapters.abstracts;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
