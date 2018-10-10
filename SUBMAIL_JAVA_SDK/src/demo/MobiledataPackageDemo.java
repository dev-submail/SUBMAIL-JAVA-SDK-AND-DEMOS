package demo;

import utils.ConfigLoader;
import config.AppConfig;
import lib.MobiledataPackage;


public class MobiledataPackageDemo {

	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mobiledata);
		MobiledataPackage submail = new MobiledataPackage(config);
		submail.sel();;
	}	
}