package cloud.expertos.labs.archaws.lambda;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class UserDAO extends AbstractDAO implements IUserDAO {

	private static UserDAO INSTANCE = null;

	public static synchronized UserDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UserDAO();
		}
		return INSTANCE;
	}

	@Override
	public void save(User user) {
		getMapper().save(user);
	}

	@Override
	public List<User> findUsersByDep(String dep) {

		final Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":val1", new AttributeValue().withS(dep));

		final DynamoDBQueryExpression<User> queryExpression = new DynamoDBQueryExpression<User>().withKeyConditionExpression(" depId = :val1 ").withExpressionAttributeValues(eav);

		return getMapper().query(User.class, queryExpression);
	}

	@Override
	public void save(Collection<User> users) {
		getMapper().batchSave(users);
	}
}
