package cloud.expertos.labs.archaws.lambda;

public class Query {

	@Override
	public String toString() {
		return "Query [depId=" + depId + "]";
	}

	private String depId;

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

}