package PassDataUsingConfigProp;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropEx {

	Properties prop;
	public  ConfigPropEx() throws Exception{
		
	FileInputStream fis= new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\com.org.lnt.Finance\\TestData\\config.properties");
	
	prop = new Properties();
	prop.load(fis);
	}
	public String getAppURL() {
		return prop.getProperty("url");
		
	}
	public String getAdminuser() {
		return prop.getProperty("username");
	}
	public String getAdminPassword() {
		return prop.getProperty("password");
	}
}