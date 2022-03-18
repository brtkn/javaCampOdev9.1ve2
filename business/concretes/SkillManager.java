package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {
		skillDao.save(skill);
		return new SuccessResult("Skill added.");
	}

	@Override
	public Result update(Skill skill) {
		skillDao.save(skill);
		return new SuccessResult("Skill updated.");
	}

	@Override
	public Result delete(Skill skill) {
		skillDao.delete(skill);
		return new SuccessResult("Skill deleted.");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(skillDao.findAll(), "All related data listed.");
	}

	@Override
	public DataResult<Skill> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
