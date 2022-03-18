package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name="employers")
public class Employer extends User{
	
	
	
	
	@Column(name="company_name")
	String companyName;
	
	@Column(name="website")
	String website;
	
	@Column(name="company_mail")
	String companyMail;
	
	@Column(name="telephone_number")
	String telephoneNumber;
	
	@Column(name="password")
	String password;
	
	
}
