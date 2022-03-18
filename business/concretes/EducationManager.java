package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{
	
	EducationDao educationDao;
	
	public EducationManager(EducationDao educationDao) {
		
		this.educationDao = educationDao;
	}
	
	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Education added");
	}

	@Override
	public Result update(Education education) {
		educationDao.save(education);
		return new SuccessResult("Education updated");
	}

	@Override
	public Result delete(Education education) {
		educationDao.delete(education);
		return new SuccessResult("Education deleted.");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(educationDao.findAll(),"All related data listed!(Education)");
	}

	@Override
	public DataResult<Education> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
