package kodlamaio.hrms.adapters.mailConfirmationService;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;

public interface MailConfirmationService {
	public Result confirmUser(User user);
}
