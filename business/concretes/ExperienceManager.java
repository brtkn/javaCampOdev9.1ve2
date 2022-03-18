package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	
	private ExperienceDao experienceDao;
	

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		experienceDao.save(experience);
		return new SuccessResult("Experience added.");
	}

	@Override
	public Result update(Experience experience) {
		experienceDao.save(experience);
		return new SuccessResult("Experience updated");
	}

	@Override
	public Result delete(Experience experience) {
		experienceDao.delete(experience);
		return new SuccessResult("Experience deleted.");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
	
		return new SuccessDataResult<List<Experience>>(experienceDao.findAll(),"All data listed");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
