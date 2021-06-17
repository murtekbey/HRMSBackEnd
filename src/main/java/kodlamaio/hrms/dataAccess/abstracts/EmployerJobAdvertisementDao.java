package kodlamaio.hrms.dataAccess.abstracts;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.EmployerJobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto;


public interface EmployerJobAdvertisementDao extends JpaRepository<EmployerJobAdvertisement, Integer> {
	
//	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, t.title, j.numberOfHires, j.releaseDate, j.applicationDeadline)"
			+ "From EmployerJobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle t where j.isActive=true")
	List<JobAdvertisementWithEmployerDto> getDetails();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, t.title, j.numberOfHires, j.releaseDate, j.applicationDeadline)"
			+ "From EmployerJobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle t where j.releaseDate=:releaseDate")
	List<JobAdvertisementWithEmployerDto> getDetailsByReleaseDate(@Param("releaseDate") Date releaseDate);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, t.title, j.numberOfHires, j.releaseDate, j.applicationDeadline)"
			+ "From EmployerJobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle t where j.applicationDeadline=:applicationDeadline and j.isActive=true")
	List<JobAdvertisementWithEmployerDto> getDetailsByApplicationDeadline(@Param("applicationDeadline")LocalDate applicationDeadline);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, t.title, j.numberOfHires, j.releaseDate, j.applicationDeadline)"
			+ "From EmployerJobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle t where e.id=:employerId and j.isActive=true")
	List<JobAdvertisementWithEmployerDto> getDetailsByEmployer(@Param("employerId")int employerId);
	
	
}
