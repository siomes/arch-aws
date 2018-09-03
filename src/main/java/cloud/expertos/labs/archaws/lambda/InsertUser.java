package cloud.expertos.labs.archaws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class InsertUser implements RequestHandler<User, String> {

	final UserService service = UserService.getInstance();

	@Override
	public String handleRequest(User input, Context context) {

		context.getLogger().log("Input: " + input);

		service.saveUser(input);

		return "Usuario inser";
	}

}
