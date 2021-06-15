package kodlamaio.hrms.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.abstracts.CandidateCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
//        KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
//
//        boolean serviceResult=false;

//        try {
//        	System.out.println("Not a valid person");
//            serviceResult = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
//                    candidate.getFirstName().toUpperCase(),
//                    candidate.getLastName().toUpperCase(),
//                    candidate.getBirthYear());
//
//        } catch (Exception e) {
//
//            System.out.println("Not a valid person");
//        }

       return true; 
	}

}
