package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("api/jobpostings")
public class JobPostingsController {
	
	private JobPostingService jobPostingService;
	
	
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getById")
	public DataResult<JobPosting> getById(@RequestParam int id){
		return  this.jobPostingService.getById(id);
	}
	
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobPosting>> getAllByIsActive(@RequestParam boolean isActive){
		return this.jobPostingService.getAllByIsActive(isActive);
	}
	
	@GetMapping("/getAllActiveOnesSortedByPostingDate")
	public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDate(){
		return this.jobPostingService.getAllByActiveOnesSortedByPostingDate();
	}
	
	@GetMapping("/getAllActiveOnesByEmployerIdSortedByPostingDate")
	public DataResult<List<JobPosting>> getAllActiveOnesByEmployerIdSortedByPostingDate(@RequestParam int employerId){
		return this.jobPostingService.getAllByActiveOnesByEmployerIdSortedByPostingDate(employerId);
	}
	
	@PutMapping("/makeActiveOrPassive")    //Use PUT when we want to modify a singular resource that is already a part of resources collection
	public Result makeActiveOrPassive(@RequestParam int id, @RequestParam boolean isActive ) {
		return this.jobPostingService.makeActiveOrPassive(id, isActive);
	}
}
