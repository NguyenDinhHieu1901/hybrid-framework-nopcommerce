package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${env}.properties" })
public interface Environment extends Config {
	@Key("app.url")
	String getApplicationUrl();

	@Key("app.username")
	String getApplicationUserName();

	@Key("app.password")
	String getApplicationPassword();
}
