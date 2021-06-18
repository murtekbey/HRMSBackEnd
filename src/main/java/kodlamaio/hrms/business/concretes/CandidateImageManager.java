package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.adapters.cloudinaryService.CloudinaryService;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManager implements CandidateImageService {

	private CandidateImageDao candidateImageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CandidateImageManager(CloudinaryService cloudinaryService) {
		super();
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(CandidateImage candidateImage, MultipartFile multipartFile) throws IOException {
		@SuppressWarnings("rawtypes")
		Map photoMap = cloudinaryService.upload(multipartFile);
		candidateImage.setImageUrl(photoMap.get("url").toString());
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Fotoğraf eklendi");
	}
	
	@Override
	public Result update(CandidateImage candidateImage, MultipartFile multipartFile) throws IOException {
		@SuppressWarnings("rawtypes")
		Map photoMap = cloudinaryService.upload(multipartFile);
		candidateImage.setImageUrl(photoMap.get("url").toString());
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Fotoğraf güncellendi");
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll());
	}

}
