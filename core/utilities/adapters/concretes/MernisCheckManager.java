package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobCandidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public Result checkIfRealPerson(JobCandidate jobCandidate) throws Exception {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobCandidate.getIdentityNumber()), jobCandidate.getFirstName().toUpperCase(new Locale("tr","TR")), jobCandidate.getLastName().toUpperCase(new Locale("tr","TR")),Integer.parseInt(jobCandidate.getDateOfBirth()));
		
		if(!result) {
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}

}
