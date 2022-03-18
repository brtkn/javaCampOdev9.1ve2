package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobCandidate;
import kodlamaio.hrms.entities.concretes.LanguageLevel;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeWithAllRelatedEntitiesDto {
	
	private int id;
	
	private LocalDateTime creationDate;
	
	private JobCandidate jobCandidate;
	
	private CoverLetter coverLetter;
	
	private Image image;
	
	private List<Education> edivcations;
	
	private List<Experience> experiences;
	
	private List<LanguageLevel> languageLevels;
	
	private List<Link> links;
	
	private List<Skill> skills;

}
