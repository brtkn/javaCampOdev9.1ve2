package kodlamaio.hrms.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.HrmsApprovalService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service //unutma patliyor sistem
public class HrmsApprovalManager implements HrmsApprovalService{

	@Override
	public Result isApprovedFromHrms(Employer employer) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}

}
