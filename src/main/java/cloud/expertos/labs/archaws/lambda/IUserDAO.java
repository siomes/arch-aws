package cloud.expertos.labs.archaws.lambda;

import java.util.Collection;
import java.util.List;

public interface IUserDAO {

	void save(User user);

	List<User> findUsersByDep(String dep);

	void save(Collection<User> users);

}
