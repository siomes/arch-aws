package cloud.expertos.labs.archaws.lambda;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "user")
public class User {

	private String depId;
	private String userId;
	private String name;
	private Integer userAge;

	@DynamoDBHashKey(attributeName = "depId")
	public String getDepId() {
		return depId;
	}

	@DynamoDBRangeKey(attributeName = "userId")
	public String getUserId() {
		return userId;
	}

	@DynamoDBAttribute(attributeName = "name")
	public String getName() {
		return name;
	}

	@DynamoDBAttribute(attributeName = "userAge")
	public Integer getUserAge() {
		return userAge;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depId == null) ? 0 : depId.hashCode());
		result = prime * result + ((userAge == null) ? 0 : userAge.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (depId == null) {
			if (other.depId != null)
				return false;
		} else if (!depId.equals(other.depId))
			return false;
		if (userAge == null) {
			if (other.userAge != null)
				return false;
		} else if (!userAge.equals(other.userAge))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [depId=" + depId + ", userId=" + userId + ", name=" + name + ", userAge=" + userAge + "]";
	}

}