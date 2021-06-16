package kodlamaio.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="users", uniqueConstraints=@UniqueConstraint(columnNames= {"email"}))
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="email", unique=true)
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email can not be blank")
	@NotNull(message = "Email can not be null")
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
	private String password;
}
