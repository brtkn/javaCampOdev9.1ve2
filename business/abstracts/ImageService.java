package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;


public interface ImageService extends BaseEntityService<Image> {
	
	Result upload(int userId, MultipartFile file);
	
	DataResult<Image> getByUserId(int userId);
}
