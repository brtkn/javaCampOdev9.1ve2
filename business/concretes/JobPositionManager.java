package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		
		return  new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data listed") ;
	}
	
	public Result isJobPositionExist(String positionName) {
		if(jobPositionDao.findByPositionName(positionName) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		
		/*
		 * this.jobPositionDao.save(jobPosition); return new
		 * SuccessResult("Data added.");
		 */
		
		if(!this.isJobPositionExist(jobPosition.getPositionName()).isSuccess()) {
			return new ErrorResult("This position is already exist.");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position successfully added.");
	}

}
