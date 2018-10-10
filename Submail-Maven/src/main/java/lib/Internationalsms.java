package lib;

import java.util.Map;

import config.AppConfig;
import lib.base.Sender;

/**
 * 国际短信api
 * 
 * @author submail
 *
 */
public class Internationalsms extends Sender {

	private static final String API_SEND = "http://api.submail.cn/internationalsms/send.json";
	private static final String API_XSEND = "http://api.submail.cn/internationalsms/xsend.json";
	private static final String API_MULTIXSEND = "http://api.submail.cn/internationalsms/multixsend.json";
	private static final String API_BALANCE = "http://api.mysubmail.com/balance/internationalsms.json";

	public Internationalsms(AppConfig config) {
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
	public String multixsend(Map<String, Object> data) {
		return request(API_MULTIXSEND, data);
	}

	@Override
	public String balance(Map<String, Object> data) {
		return request(API_BALANCE, data);
	}

}
