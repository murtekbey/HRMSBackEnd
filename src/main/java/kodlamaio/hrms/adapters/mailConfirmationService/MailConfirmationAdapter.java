package kodlamaio.hrms.adapters.mailConfirmationService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class MailConfirmationAdapter implements MailConfirmationService {

	@Override
	public Result confirmUser(User user) {
		return new SuccessResult(user.getEmail() + " mail confirmation is completed");
	}

}
