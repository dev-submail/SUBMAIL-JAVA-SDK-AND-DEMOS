package demo;

import config.AppConfig;
import lib.MessageLog;
import lib.VoiceSend;
import utils.ConfigLoader;
import utils.UnixStamp;

public class MessageLogDemo {
	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageLog submail = new MessageLog(config);
		submail.setProject("project","w3nla3");
		submail.addStartDate("start_date",UnixStamp.date2TimeStamp("2017-08-12 00:00:00","yyyy-MM-dd HH:mm:ss"));
		submail.addEndDate("end_date",UnixStamp.date2TimeStamp("2017-11-13 00:00:00","yyyy-MM-dd HH:mm:ss"));
		String response=submail.log();
		System.out.println("接口返回数据："+response);
	}

}
