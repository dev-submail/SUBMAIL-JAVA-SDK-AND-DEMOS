package demo;

import utils.ConfigLoader;
import config.AppConfig;
import lib.MobiledataCharge;
import lib.MobiledataPackage;
import lib.MobiledataTOservice;

public class MobiledataChargeDemo {

	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mobiledata);
		MobiledataCharge submail = new MobiledataCharge(config);
		submail.addTo("1760*****49");
		submail.addCu("cu20");
		submail.charge();
		
	}	
}