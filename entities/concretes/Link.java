package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="links")
public class Link {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="url")
	private String url;
	
	
	@ManyToOne
	@JoinColumn(name="link_name_id")
	private LinkName linkName;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	
}
