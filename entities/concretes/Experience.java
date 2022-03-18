package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="experience")
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
	
	@Column(name="termination_date")
	private LocalDate terminationDate;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@ManyToOne
	@JoinColumn(name="job_postion_title")
	private JobPosition JobPosition;
	
	public String getTerminationDate() {
		if(terminationDate == null) {
			return "Continuing Job";
		}
		
		return terminationDate.toString();
	}
	
	
	
}
