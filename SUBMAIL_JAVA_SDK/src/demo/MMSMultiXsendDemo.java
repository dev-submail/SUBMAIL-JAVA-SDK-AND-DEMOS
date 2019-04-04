package demo;

import config.AppConfig;
import lib.MMSMultiXSend;
import net.sf.json.JSONObject;
import utils.ConfigLoader;

public class MMSMultiXsendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
		MMSMultiXSend submail = new MMSMultiXSend(config);
		submail.addProject("g8xxx1");
		JSONObject json = new JSONObject();
		json.put("name", "张三");
		json.put("code", "1123");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("137xxxx");

		JSONObject json2 = new JSONObject();
		json2.put("name", "老江");
		json2.put("code", "11244");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("182xxxx40");
		String response = submail.multixsend();
		System.out.println("接口返回消息:" + response);
	}

}
