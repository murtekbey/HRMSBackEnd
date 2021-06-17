package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerDto {
	private int id;
	private String companyName;
	private String jobTitle;
	private int numberOfHires;
	private Date releaseDate;
	private LocalDate applicationDeadline;
}
