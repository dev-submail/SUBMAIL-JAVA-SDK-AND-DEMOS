package demo;

import config.AppConfig;
import lib.MessageBalance;
import utils.ConfigLoader;

public class MessageBalanceDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageBalance submail = new MessageBalance(config);
		System.out.println(submail.balance());
	}

}
