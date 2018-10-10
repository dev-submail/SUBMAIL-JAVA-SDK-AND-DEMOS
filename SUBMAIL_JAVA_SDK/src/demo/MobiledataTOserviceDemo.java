package demo;

import utils.ConfigLoader;
import config.AppConfig;
import lib.MobiledataPackage;
import lib.MobiledataTOservice;


public class MobiledataTOserviceDemo {

	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mobiledata);
		MobiledataTOservice submail = new MobiledataTOservice(config);
		submail.addTo("176****49");
		submail.addAddressbook("Afde22");
		submail.TOservice();
		
	}	
}