package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","verificationCodeEmployers","employeeConfirmEmployers"})
public class Employer extends User {
	
	@NotBlank
	@NotNull
	@Size(min = 2, message = "Company name must be at least 2 characters")
	@Column(name="company_name", unique=true)
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name="web_address", unique=true)
	@Pattern(regexp = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$",
	message = "Not a valid web address")
	private String webAddress;
	
	@NotBlank
	@NotNull
	@Column(name="phone_number", unique=true)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployeeConfirmEmployer> employeeConfirmEmployers;
	
	@OneToMany(mappedBy = "employer")
	private List<VerificationCodeEmployer> verificationCodeEmployers;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployerJobAdvertisement> employerJobAdvertisements;
}
