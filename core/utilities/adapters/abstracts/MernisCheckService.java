package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobCandidate;

public interface MernisCheckService {
	
	Result checkIfRealPerson(JobCandidate jobCandidate) throws Exception;

}
