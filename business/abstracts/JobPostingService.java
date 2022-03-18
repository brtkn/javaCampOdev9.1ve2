package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	DataResult<List<JobPosting>> getAll();
	
	Result add(JobPosting jobPosting);
	
	Result update(JobPosting jobPosting);
	
	DataResult<JobPosting> getById(int id);
	
	Result makeActiveOrPassive(int id, boolean isActive);
	
	DataResult<List<JobPosting>> getAllByIsActive(boolean isActive);
	
	DataResult<List<JobPosting>> getAllByActiveOnesSortedByPostingDate();
	
	DataResult<List<JobPosting>> getAllByActiveOnesByEmployerIdSortedByPostingDate(int employerId);
	

}
