package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{
	
	Resume getByJobCandidate_Id(int jobCandidate); //Dogru mu yazdin kontrol et job_candidate_id sorun cikar.
	
	Resume getByCoverLetter_id(int coverLetterId);
}
