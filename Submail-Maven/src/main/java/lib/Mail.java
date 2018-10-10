package lib;

import java.util.Map;

import config.AppConfig;
import lib.base.Sender;

/**
 * 邮件api
 * 
 * @author submail
 *
 */
public class Mail extends Sender {

	private static final String API_SEND = "http://api.submail.cn/mail/send.json";
	private static final String API_XSEND = "http://api.submail.cn/mail/xsend.json";
	private static final String API_SUBSCRIBE = "http://api.submail.cn/addressbook/mail/subscribe.json";
	private static final String API_UNSUBSCRIBE = "http://api.submail.cn/addressbook/mail/unsubscribe.json";
	private static final String API_BALANCE = "http://api.mysubmail.com/balance/mail.json";

	public Mail(AppConfig config) {
		this.config = config;
	}

	@Override
	public String send(Map<String, Object> data) {
		return request(API_SEND, data);
	}

	@Override
	public String xsend(Map<String, Object> data) {
		return request(API_XSEND, data);
	}

	@Override
	public String subscribe(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_SUBSCRIBE, data);
	}

	@Override
	public String unsubscribe(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_UNSUBSCRIBE, data);
	}

	@Override
	public String balance(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_BALANCE, data);
	}

}
