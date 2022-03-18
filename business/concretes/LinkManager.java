package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {
	
	private LinkDao linkDao;

	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		linkDao.save(link);
		return new SuccessResult("link added");
	}

	@Override
	public Result update(Link link) {
		linkDao.save(link);
		return new SuccessResult("link updated");
	}

	@Override
	public Result delete(Link link) {
		linkDao.delete(link);
		return new SuccessResult("link deleted");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		
		return new SuccessDataResult<List<Link>>(linkDao.findAll(), "All related data listed.");
	}

	@Override
	public DataResult<Link> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
