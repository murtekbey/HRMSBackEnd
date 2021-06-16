package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_confirm_employers")
@PrimaryKeyJoinColumn(name = "employee_confirm_id", referencedColumnName = "id")
public class EmployeeConfirmEmployer extends EmployeeConfirm {
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
}
