package demo;

import config.AppConfig;
import lib.VoiceMultiXSend;
import lib.VoiceXSend;
import utils.ConfigLoader;

public class VoiceMultiXSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceMultiXSend submail = new VoiceMultiXSend(config);
		submail.addProject("WZlIv4");
		submail.getVars("name", "张三", "code", "2256");
		submail.addMulti("176*****49");
		
//		submail.getVars("name", "xxx", "code", "3345");
//		submail.addMulti("176*****49");

		submail.multixsend();
	}

}
