package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.dataAccess.UserDao;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(userDao.findAll(), "All users listed");
	}

	@Override
	public DataResult<User> getById(int id) {
		
		return new SuccessDataResult<User>(userDao.getById(id), "User listed (by  identity)");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
		return new SuccessDataResult<User>(userDao.getByEmail(email), "User mail");
	}

}
