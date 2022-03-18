package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.hrms.entities.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService {
	
	private LanguageLevelDao languageLevelDao;
	
	
	@Autowired
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		super();
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public Result add(LanguageLevel languageLevel) {
		languageLevelDao.save(languageLevel);
		return new SuccessResult("Language level added");
	}

	@Override
	public Result update(LanguageLevel languageLevel) {
		languageLevelDao.save(languageLevel);
		return new SuccessResult("Language level updated");
	}

	@Override
	public Result delete(LanguageLevel languageLevel) {
		languageLevelDao.delete(languageLevel);
		return new SuccessResult("Language level deleted");
	}

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		
		return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll(), "All related data listed");
	}

	@Override
	public DataResult<LanguageLevel> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
