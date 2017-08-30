package demo;

import utils.ConfigLoader;
import config.AppConfig;
import lib.MAILSend;

public class MailSendDemo {

	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
		MAILSend submail = new MAILSend(config);
//		submail.addTo("leo@submail.cn","leo");
		submail.addTo("leo@submail.cn","leo");
		submail.addCc("mailer@submail.cn", "");
		submail.addBcc("leo@drinkfans.com", "");
		submail.setSender("no-reply@submail.cn","SUBMAIL");
		submail.setReply("service@submail.cn");
		submail.setSubject("test SDK");
		submail.setText("test SDK text");
		submail.addAttachment("D:\\Program Files\\eclipse-php-luna-SR1-win32\\eclipse\\epl-v10.html");
		submail.setHtml("test SDK html @var(name),@var(age) <a href=\"var://@link(test)\">testLink</a> <a href=\"var://@link(test2)\">testLink2</a>");
		submail.addVar("name", "leo");
		submail.addVar("age", "32");
		submail.addLink("developer", "http://submail.cn/chs/developer");
		submail.addLink("store", "http://submail.cn/chs/store");
		submail.addHeaders("X-Accept", "zh-cn");
		submail.addHeaders("X-Mailer", "leo App");
		submail.send();
	}	
}
