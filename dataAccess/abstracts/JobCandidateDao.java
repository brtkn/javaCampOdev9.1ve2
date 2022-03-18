package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobCandidate;

public interface JobCandidateDao extends JpaRepository<JobCandidate, Integer> {
	
	JobCandidate findByIdentityNumber(String nationalityId);
	JobCandidate findByEmail(String email);
	
}
