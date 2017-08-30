package demo;

import config.AppConfig;
import lib.MessageMultiXSend;
import lib.VoiceMultiXSend;
import lib.VoiceXSend;
import utils.ConfigLoader;

public class MessageMultiXsendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageMultiXSend submail = new MessageMultiXSend(config);
		submail.addProject("w3nla3");
		submail.getVars("code", "张三", "herf", "www.baidu.com");
		submail.addMulti("17****49");
		submail.getVars("name", "陈凯", "herf", "www.baidu.com");
		submail.addMulti("17****61");
		submail.multixsend();
	}

}
