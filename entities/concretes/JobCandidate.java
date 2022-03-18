package kodlamaio.hrms.entities.concretes;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="job_candidates")
public class JobCandidate extends User {
	
	
	
	@NotNull
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="telephone_number")
	private String telephoneNumber;
	
	//veri tabaninda data tipi Date oldugu icin illegal access this web application instance has been stopped hatasi aldin.
	@Column(name="date_of_birth")
	private String dateOfBirth;
}
