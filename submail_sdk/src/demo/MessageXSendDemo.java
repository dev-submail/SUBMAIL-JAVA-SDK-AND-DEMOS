package demo;

import utils.ConfigLoader;
import config.AppConfig;
import lib.MESSAGEXsend;

public class MessageXSendDemo {

	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MESSAGEXsend submail = new MESSAGEXsend(config);
		submail.addTo("17602115149");
		submail.setProject("w3nla3");
		submail.addVar("code", "张三");
		submail.addVar("minue", "2289");
		submail.xsend();
	}	
}
