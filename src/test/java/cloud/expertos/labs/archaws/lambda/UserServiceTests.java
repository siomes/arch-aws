package cloud.expertos.labs.archaws.lambda;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTests {

	private UserService service = null;

	@Before
	public void createInput() throws IOException {
		service = UserService.getInstance();
	}

	@Test
	public void crearUsuario() {

		User user = new User();
		user.setDepId("dep001");
		user.setUserId("user001");
		user.setUserAge(50);
		user.setName("Ana");
		service.saveUser(user);

		List<User> existentes = service.findUsersByDep("dep001");
		assertTrue(existentes.contains(user));
	}
	
	@Test
	public void usuariosDep() {

		User user = new User();
		user.setDepId("dep001");
		user.setUserId("user001");
		user.setUserAge(50);
		user.setName("Ana");
		service.saveUser(user);
		
		User user2 = new User();
		user2.setDepId("dep001");
		user2.setUserId("user002");
		user2.setUserAge(30);
		user2.setName("Olga");
		service.saveUser(user2);

		List<User> existentes = service.findUsersByDep("dep001");
		assertTrue(existentes.contains(user));
		assertTrue(existentes.contains(user2));
	}

}
