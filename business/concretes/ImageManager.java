package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.adapters.concretes.CloudinaryManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.User;
import lombok.var;


@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	private UserService userService;

	public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService, UserService userService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
		this.userService = userService;
	}

	@Override
	public Result add(Image image) {
		imageDao.save(image);
		return new SuccessDataResult<Image>("Image added");
	}

	@Override
	public Result update(Image image) {
		imageDao.save(image);
		return new SuccessDataResult<Image>("Image updated");
	}

	@Override
	public Result delete(Image image) {
		
		return null;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>(imageDao.findAll(), "All images listed");
	}

	@Override
	public DataResult<Image> getById(int id) {
		
		return new SuccessDataResult<Image>(imageDao.getById(id), "Image listed (by id)");
	}

	@Override
	public Result upload(int userId, MultipartFile file) {
		
		Map<?,?> uploadImage = (Map<?,?>) cloudinaryService.uploadImage(file).getData();
		
		Image image = new Image();
		image.setUser(userService.getById(userId).getData());
		image.setImageUrl(uploadImage.get("url").toString());
		
		return add(image);
	}

	@Override
	public DataResult<Image> getByUserId(int userId) {
		
		return new SuccessDataResult<Image>(imageDao.getByUser_Id(userId),"Image added (by user id)");
	}
	
	

}
