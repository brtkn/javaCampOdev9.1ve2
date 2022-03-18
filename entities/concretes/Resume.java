package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="resumes")
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate;
	
	
	@OneToOne
	@JoinColumn(name="job_candidate_id")
	private JobCandidate jobCandidate;
	
	@JsonIgnore //The property is ignored both when reading JSON into Java objects, and when writing Java objects into JSON
	@OneToOne
	@JoinColumn(name="cover_letter_id")
	private CoverLetter coverLetter;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")   //Always mappedBy attribute is used in bidirectional association to link with other side of entity
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<LanguageLevel> languageLevels;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Link> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Skill> skills;
	
	
	
	
	public Resume(JobCandidate jobCandidate) {
		this.setJobCandidate(jobCandidate);
		
	}
	
	
}
