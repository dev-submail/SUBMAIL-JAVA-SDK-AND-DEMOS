package demo;

import config.AppConfig;
import lib.InternationalsmsMultiXSend;
import lib.VoiceMultiXSend;
import lib.VoiceXSend;
import utils.ConfigLoader;

public class InternationalsmsMultiXSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsMultiXSend submail = new InternationalsmsMultiXSend(config);
		submail.addProject("w3nna3");
		submail.getVars("name", "张三", "code", "2238");
		submail.addMulti("176******29");
		submail.getVars("code", "123", "herf", "459");
		submail.addMulti("173******61");

		submail.multixsend();
	}

}
