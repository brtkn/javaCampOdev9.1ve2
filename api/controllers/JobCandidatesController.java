package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobCandidate;

@RestController
@RequestMapping("api/jobcandidate")
public class JobCandidatesController {

		private JobCandidateService candidateService;
		
		public JobCandidatesController(JobCandidateService candidateService) {
			super();
			this.candidateService = candidateService;
		}
		
		@GetMapping("/getall")
		public DataResult<List<JobCandidate>> getAll() {
			return this.candidateService.getAll();
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody JobCandidate jobCandidate) throws Exception {
			return this.candidateService.add(jobCandidate);
		}
		
		
}
