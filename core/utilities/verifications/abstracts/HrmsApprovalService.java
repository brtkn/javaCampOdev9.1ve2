package kodlamaio.hrms.core.utilities.verifications.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface HrmsApprovalService {
	public Result isApprovedFromHrms(Employer employer);
}
