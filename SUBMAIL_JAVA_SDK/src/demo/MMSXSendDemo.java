package demo;

import config.AppConfig;
import lib.MMSXSend;
import utils.ConfigLoader;

public class MMSXSendDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
		MMSXSend submail = new MMSXSend(config);
		submail.addTo("176xxx149");
		submail.setProject("w3xxxa3");
		submail.addVar("code", "张三");
		submail.addVar("minue", "2289");
		String response = submail.xsend();
		System.out.println("接口返回数据：" + response);
	}

}
