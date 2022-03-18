package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="job_positions")
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="position_name")
	String positionName;
	
	
	public JobPosition() {
		
	}
	
	public JobPosition(int id, String positionName) {
		super();
		this.id = id;
		this.positionName = positionName;
	}
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPositionName() {
		return positionName;
	}
	
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	

}
