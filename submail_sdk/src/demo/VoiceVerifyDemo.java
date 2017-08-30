package demo;

import config.AppConfig;
import lib.VoiceVerify;
import lib.VoiceXSend;
import utils.ConfigLoader;

public class VoiceVerifyDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceVerify submail = new VoiceVerify(config);
		submail.addTo("176*****49");
		submail.addCode("3322");
		submail.verify();
	}

}
