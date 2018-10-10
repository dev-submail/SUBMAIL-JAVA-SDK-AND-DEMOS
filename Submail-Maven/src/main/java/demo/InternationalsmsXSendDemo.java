package demo;

import config.AppConfig;
import lib.Internationalsms;
import lib.InternationalsmsXSend;
import lib.VoiceXSend;
import utils.ConfigLoader;

public class InternationalsmsXSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsXSend submail = new InternationalsmsXSend(config);
		submail.addTo("176****49");
		submail.addProject("w3nla3");
		submail.addVars("name","李四");
		submail.addVars("code","2299");
		submail.xsend();
	}

}
