package cloud.expertos.labs.archaws.lambda;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class FindUsers implements RequestHandler<Query, List<User>> {

	final UserService service = UserService.getInstance();

	@Override
	public List<User> handleRequest(Query input, Context context) {

		context.getLogger().log("Consultado usuarios para consulta: " + input);

		final List<User> users = service.findUsersByDep(input.getDepId());

		return users;
	}

}
