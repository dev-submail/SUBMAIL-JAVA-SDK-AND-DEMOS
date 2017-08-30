package demo;

import config.AppConfig;
import lib.VoiceXSend;
import utils.ConfigLoader;

public class VoiceXSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceXSend submail = new VoiceXSend(config);
		submail.addTo("176*****49");
		submail.addProject("WZlIv3");
		submail.addVars("name","张三");
		submail.addVars("code","2244");
		submail.xsend();
	}

}
