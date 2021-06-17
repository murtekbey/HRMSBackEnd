package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_job_advertisements")
@PrimaryKeyJoinColumn(name = "job_advertisement_id", referencedColumnName = "id")
public class EmployerJobAdvertisement extends JobAdvertisement {

	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name = "is_active")
	private boolean isActive;
}
