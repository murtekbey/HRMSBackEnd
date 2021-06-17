package kodlamaio.hrms.adapters.verificationCodeService;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationCodeGeneratorAdapter implements VerificationCodeGeneratorService {

	@Override
	public String generateVerificationCode() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

}
