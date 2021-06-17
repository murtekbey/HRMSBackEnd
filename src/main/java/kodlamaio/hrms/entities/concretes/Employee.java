package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee_confirms"})
public class Employee extends User {
	
	@NotBlank
	@NotNull
	@Size(min = 2, message = "First name must be at least 2 characters")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Size(min = 2, message = "Last name must be at least 2 characters")
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(mappedBy= "employee")
	private List<EmployeeConfirm> employeeConfirms;
}
