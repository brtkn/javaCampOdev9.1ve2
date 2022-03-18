package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{
	
	JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
	}

	@Override
	public Result add(JobPosting jobPosting) {
		// TODO Auto-generated method stub
		jobPosting.setPostingDate(LocalDateTime.now());
		jobPosting.setActive(true);
		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job Posting added!");
	}

	@Override
	public Result makeActiveOrPassive(int id, boolean isActive) {
		
		String statusMessage = isActive ? "Posting is activated" : "Posting is deactivated" ;
		
		JobPosting jobPosting = getById(id).getData();
		jobPosting.setActive(isActive);
		
		update(jobPosting);
		return new SuccessDataResult<JobPosting>(statusMessage);
		
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(isActive));
	}

	@Override
	public DataResult<List<JobPosting>> getAllByActiveOnesSortedByPostingDate() {
		Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");
		
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(true, sort));
	}

	@Override
	public DataResult<List<JobPosting>> getAllByActiveOnesByEmployerIdSortedByPostingDate(int employerId) {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");
		
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActiveAndEmployer_Id(true, employerId, sort));
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobPosting>(jobPostingDao.getById(id));
	}

	@Override
	public Result update(JobPosting jobPosting) {
		// TODO Auto-generated method stub
		jobPostingDao.save(jobPosting);
		return new SuccessDataResult<JobPosting>("Job posting is updated!");
	}

}
