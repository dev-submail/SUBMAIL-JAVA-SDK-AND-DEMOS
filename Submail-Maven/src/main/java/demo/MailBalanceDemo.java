package demo;

import config.AppConfig;
import lib.MailBalance;
import utils.ConfigLoader;

public class MailBalanceDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
		MailBalance submail = new MailBalance(config);
		System.out.println(submail.balance());
	}

}
