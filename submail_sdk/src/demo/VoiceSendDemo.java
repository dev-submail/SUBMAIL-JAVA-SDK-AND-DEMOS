package demo;

import config.AppConfig;
import lib.MESSAGEXsend;
import lib.VoiceSend;
import utils.ConfigLoader;

public class VoiceSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceSend submail = new VoiceSend(config);
		submail.addTo("176****49");
		submail.addContent("欢迎来到中国，welcome to china");
		submail.send();
		System.out.println(submail.send());
	}

}
