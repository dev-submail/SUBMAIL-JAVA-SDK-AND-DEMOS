package demo;

import utils.ConfigLoader;
import config.AppConfig;
import lib.ADDRESSBOOKMessage;

public class AddressBookMessageUnSubscribe {

	public static void main(String[] args) {

		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		ADDRESSBOOKMessage addressbook = new ADDRESSBOOKMessage(config);
		addressbook.setAddress("186****1889");
		addressbook.unsubscribe();
	}	
}
