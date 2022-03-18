package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeWithAllRelatedEntitiesDto;

@Service
public class ResumeManager implements ResumeService {
	
	
	private ResumeDao resumeDao;
	private ImageService imageService;
	private EducationService educationService;
	private ExperienceService experienceService;
	private CoverLetterService coverLetterService;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, ImageService imageService, EducationService educationService,
			ExperienceService experienceService, CoverLetterService coverLetterService) {
		super();
		this.resumeDao = resumeDao;
		this.imageService = imageService;
		this.educationService = educationService;
		this.experienceService = experienceService;
		this.coverLetterService = coverLetterService;
	}

	
	
	@Override
	public DataResult<List<Resume>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(),"All resumes are listed.");
	}

	@Override
	public Result add(Resume resume) {
		// TODO Auto-generated method stub
		this.resumeDao.save(resume);
		return new SuccessResult("Resume is added");
	}


	@Override
	public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByJobCandidateId(int candidateId) {
		
		Resume resume = getByJobCandidateId(candidateId).getData();
		
		ResumeWithAllRelatedEntitiesDto resumeWithAllRelatedEntitiesDto = new ResumeWithAllRelatedEntitiesDto(
				resume.getId(),
				resume.getCreationDate(),
				resume.getJobCandidate(),
				resume.getCoverLetter(),
				imageService.getByUserId(candidateId).getData(),
				educationService.getAll().getData(), //buralarda id sine gore yapmalisin
				experienceService.getAll().getData(), // id ye gore olmali
				resume.getLanguageLevels(),
				resume.getLinks(),
				resume.getSkills()
				);

		return new SuccessDataResult<ResumeWithAllRelatedEntitiesDto>(resumeWithAllRelatedEntitiesDto);
	}


	@Override
	public DataResult<Resume> getByJobCandidateId(int candidateId) {
		return new SuccessDataResult<Resume>(resumeDao.getByJobCandidate_Id(candidateId));
	}

}
