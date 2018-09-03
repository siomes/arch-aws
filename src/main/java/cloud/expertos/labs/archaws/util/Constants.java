package cloud.expertos.labs.archaws.util;

import java.time.ZoneId;

import com.amazonaws.regions.Regions;

public final class Constants {

	public static final Regions DEFAULT_REGION = Regions.EU_WEST_1;

	public static final String ENV_VAR_ENVIRONMENT_STATE_NAME = "ENV";

	public static final ZoneId DEFAULT_ZONE = ZoneId.of("Europe/Paris");

	public static boolean isProd() {
		String env = System.getenv(Constants.ENV_VAR_ENVIRONMENT_STATE_NAME);
		if (env != null && env.equalsIgnoreCase(Env.PROD.name())) {
			return false;
		}
		return true;
	}

}
