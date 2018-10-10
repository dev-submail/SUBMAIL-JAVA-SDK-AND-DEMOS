package demo;

import config.AppConfig;
import lib.MessageMultiSend;
import net.sf.json.JSONObject;
import utils.ConfigLoader;

public class MessageMultiSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageMultiSend submail = new MessageMultiSend(config);
		submail.addContent("【SUBMAIL】您好，您的验证码是@var(code),请在@var(time)分钟内输入");
		JSONObject json = new JSONObject();
		json.put("code", "1111");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("17602115149");

		JSONObject json2 = new JSONObject();
		json2.put("code", "2222");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("18226187949");
		String response = submail.multixsend();
		System.out.println("接口返回消息:" + response);
	}

}
