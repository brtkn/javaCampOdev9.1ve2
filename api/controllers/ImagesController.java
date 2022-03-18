package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;
	
	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		
		return imageService.getAll();	
	}
	
	@PostMapping("/upload")
	public Result upload(@RequestParam int userId, @RequestParam MultipartFile file) {
		
		return imageService.upload(userId, file);
	}
	

}
