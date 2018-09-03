package cloud.expertos.labs.archaws.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import cloud.expertos.labs.archaws.util.Constants;

public abstract class AbstractDAO {

	private AmazonDynamoDB client = null;
	private DynamoDBMapper mapper = null;

	public AbstractDAO() {
		client = AmazonDynamoDBClient.builder().withRegion(Constants.DEFAULT_REGION).build();
		mapper = new DynamoDBMapper(client);
	}

	public AmazonDynamoDB getClient() {
		return client;
	}

	public DynamoDBMapper getMapper() {
		return mapper;
	}

}
