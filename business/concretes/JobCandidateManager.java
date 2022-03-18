package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobCandidateService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobCandidateDao;
import kodlamaio.hrms.entities.concretes.JobCandidate;

@Service
public class JobCandidateManager implements JobCandidateService{

	private JobCandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	public JobCandidateManager(JobCandidateDao candidateDao, MernisCheckService mernisCheckService, EmailVerificationService emailVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
	}
	
	

	@Override
	public DataResult<List<JobCandidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobCandidate>>(this.candidateDao.findAll(),"All candidates listed.");
	}
	
	private Result isEmailExist(String email) {
		if(this.candidateDao.findByEmail(email) != null	) {
			return new ErrorResult("This email adress has already been taken.");
		}
		
		return new SuccessResult();
	}
	
	private Result isNationalityIdExist(String nationailityId) {
		if(this.candidateDao.findByIdentityNumber(nationailityId) != null) {
			return new ErrorResult("This nationality id is in use.");
		}
		
		return new SuccessResult();
	}
	
	
	@Override
	public Result add(JobCandidate jobCandidate) throws Exception {
		
		//buraya refactoring gerekiyor.
		
		/*
		 * this.candidateDao.save(jobCandidate); return new SuccessResult("Data added");
		 */
		
		if(!this.isEmailExist(jobCandidate.getEmail()).isSuccess() || !this.isNationalityIdExist(jobCandidate.getIdentityNumber()).isSuccess()) {
			return new ErrorResult("failed to add candidate");
		}
		
		Result checkedPerson;
		
		checkedPerson = mernisCheckService.checkIfRealPerson(jobCandidate);
		
		if(!this.mernisCheckService.checkIfRealPerson(jobCandidate).isSuccess()) {
			return new ErrorResult("Not a real person, please use your real Id");
		}
		
		if(!this.emailVerificationService.verifyEmail(jobCandidate.getEmail()).isSuccess()) {
			return new ErrorResult("Check your email");
		}
		
		this.candidateDao.saveAndFlush(jobCandidate);
		return new SuccessResult("Job candidate added.");
		
	}
	
	


}
