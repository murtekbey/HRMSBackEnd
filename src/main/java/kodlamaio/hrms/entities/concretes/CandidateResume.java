package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="candidate_resumes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CandidateResume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "candidateResume")
	private List<CandidateEducation> candidateEducations;
	
	@OneToMany(mappedBy = "candidateResume")
	private List<CandidateJobExperience> candidateJobExperiences;
	
	@OneToMany(mappedBy = "candidateResume")
	private List<CandidateLanguage> candidateLanguages;
	
	@OneToMany(mappedBy = "candidateResume")
	private List<CandidateImage> candidateImages;
	
	@OneToMany(mappedBy = "candidateResume")
	private List<CandidateQualification> candidateQualifications;
	
	@Nullable
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Nullable
	@Column(name = "github_address")
	private String githubAddress;
	
	@Nullable
	@Column(name = "linkedin_address")
	private String linkedinAddress;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
