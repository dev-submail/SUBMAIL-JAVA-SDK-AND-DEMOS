package demo;

import config.AppConfig;
import lib.MESSAGEXsend;
import lib.MessageSend;
import lib.VoiceSend;
import utils.ConfigLoader;

public class MessageSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageSend submail = new MessageSend(config);
		submail.addTo("176****49");
		submail.addContent("【test】你好，你的验证码是3773");
		submail.send();
	}

}
