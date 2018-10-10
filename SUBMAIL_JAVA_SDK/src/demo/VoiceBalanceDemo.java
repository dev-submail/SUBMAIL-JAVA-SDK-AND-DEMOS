package demo;

import config.AppConfig;
import lib.VoiceBalance;
import utils.ConfigLoader;

public class VoiceBalanceDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceBalance submail = new VoiceBalance(config);
		System.out.println(submail.balance());
	}

}
