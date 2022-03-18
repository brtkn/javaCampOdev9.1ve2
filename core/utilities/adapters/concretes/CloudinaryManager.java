package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

//@Service
@Component
public class CloudinaryManager implements CloudinaryService {

	private final Cloudinary cloudinary;
	
	
	
	
	public CloudinaryManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
		
	}
	
	
	@Override
	public DataResult<?> uploadImage(MultipartFile multipartFile) {
		
		try {
			Map <?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),ObjectUtils.emptyMap());
			return new SuccessDataResult<>(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>();
		}
	}
	


	@Override
	public DataResult<?> delete(String publicIdOfImage) {
		
		List<String> publicIdsOfImages = new ArrayList<String>();
		publicIdsOfImages.add(publicIdOfImage);
		
		
		try {
			
			Map<?, ?> deleteResult = cloudinary.api().deleteResources(publicIdsOfImages, ObjectUtils.emptyMap());
			return new SuccessDataResult<>(deleteResult);
			
		} catch(Throwable e) {
			
			e.printStackTrace();
			return new ErrorDataResult<>();
		}
		
	}
	
	
	

}
