package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.verifications.abstracts.HrmsApprovalService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private HrmsApprovalService hrmsApprovalService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService, HrmsApprovalService hrmsApprovalService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.hrmsApprovalService = hrmsApprovalService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return  new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listed.")  ;
	}
	
	private Result isEmailExist(String companyMail) {
		if(employerDao.findByCompanyMail(companyMail)!= null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result add(Employer employer) {
		// TODO Auto-generated method stub
		/*
		 * this.employerDao.save(employer); return new SuccessResult("Data added.");
		 */
		if(!this.isEmailExist(employer.getCompanyMail()).isSuccess()) {
			return new ErrorResult("email is already exist");
		}
		
		if(!this.hrmsApprovalService.isApprovedFromHrms(employer).isSuccess()) {
			return new ErrorResult("Employer is not approved from HRMS personal!");
		}
		
		if(!this.emailVerificationService.verifyEmail(employer.getCompanyMail()).isSuccess()) {
			return new ErrorResult("Check your email please");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
		
	}

}
