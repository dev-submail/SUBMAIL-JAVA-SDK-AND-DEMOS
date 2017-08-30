package demo;

import config.AppConfig;
import lib.InternationalsmsSend;
import lib.MESSAGEXsend;
import lib.VoiceSend;
import utils.ConfigLoader;

public class InternationalsmsSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsSend submail = new InternationalsmsSend(config);
		submail.addTo("176*****49");
		submail.addContent("您的验证码是：3345");
		submail.send();
	}

}
