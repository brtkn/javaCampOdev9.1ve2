package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //serialization sirisinda loop'a girmesini onlemek icin.
@Table(name="job_posting")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "job_description")
	private String jobDescription;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	
	@Column(name="posting_date")
	private LocalDateTime postingDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="closing_date")
	private LocalDate closingDate;
	
	@Column(name="salary_min")
	private int salaryMin;
	
	@Column(name="salary_max")
	private int salaryMax;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne(cascade=CascadeType.ALL) //When the relationship owner (superclass) is saved/ deleted, then the mapped entity associated with it should also be saved/ deleted automatically.
	@JoinColumn(name="employer_id")  //employer tablosunun id'siyle eslesecek. Burada employer_id olusuyor Postgre de.
	private Employer employer;
	
	@ManyToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="city_id")
	private City city;

	
	
}
