package demo;

import config.AppConfig;
import lib.InternationalsmsBalance;
import utils.ConfigLoader;

public class InternationalsmsBalanceDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsBalance submail = new InternationalsmsBalance(config);
		String response = submail.balance();
		System.out.println("接口返回消息:" + response);
	}

}
