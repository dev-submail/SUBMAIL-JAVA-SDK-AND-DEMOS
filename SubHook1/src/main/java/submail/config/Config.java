package submail.config;

import java.io.IOException;
import java.util.Properties;
/**
 * 读取app_config文件，获取key值
 * @author submail
 *
 */
public class Config {
	private static Properties pros = null;
	
	static {
		pros = new Properties();
		try {
			pros.load(Config.class
					.getResourceAsStream("/app_config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String messageConfig(){
	
		return pros.getProperty("message_key");
	}
	
	public static String mailConfig(){
		
		return pros.getProperty("mail_key");
	}
}
