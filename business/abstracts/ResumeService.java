package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeWithAllRelatedEntitiesDto;

public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	
	Result add(Resume resume);
	
	DataResult<Resume> getByJobCandidateId(int candidateId);
	
	DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByJobCandidateId(int candidateId);
}
