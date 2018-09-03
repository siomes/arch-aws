package cloud.expertos.labs.archaws.lambda;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);

	private IUserDAO dao = null;

	private static UserService INSTANCE = null;

	public UserService() {
		dao = UserDAO.getInstance();
	}

	public static synchronized UserService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UserService();
		}

		return INSTANCE;
	}

	public void saveUser(User user) {
		logger.debug("Guardando usuario: " + user);
		dao.save(user);
	}

	public void saveUSers(List<User> users) {
		dao.save(users);
	}

	public List<User> findUsersByDep(String dep) {
		logger.debug("Recuperando usuarios para el departamento: " + dep);
		return dao.findUsersByDep(dep);
	}

}
