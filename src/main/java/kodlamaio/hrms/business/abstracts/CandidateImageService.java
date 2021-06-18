package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {
	Result add(CandidateImage candidateImage, MultipartFile multipartFile) throws IOException;
	Result update(CandidateImage candidateImage, MultipartFile multipartFile) throws IOException;
	DataResult<List<CandidateImage>> getAll();
}
