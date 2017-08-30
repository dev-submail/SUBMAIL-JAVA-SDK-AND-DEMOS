package lib;

import java.util.Map;

import lib.base.ISender;
import lib.base.Sender;

import config.AppConfig;

/**
 * 国际短信api
 * @author submail
 *
 */
public class Internationalsms extends Sender {

	private static final String API_SEND = "http://api.submail.cn/internationalsms/send.json";
	private static final String API_XSEND = "http://api.submail.cn/internationalsms/xsend.json";
	private static final String API_MULTIXSEND = "http://api.submail.cn/internationalsms/multixsend.json";

	public Internationalsms(AppConfig config) {
		this.config = config;
	}

	
	@Override
	public boolean send(Map<String, Object> data) {
		return request(API_SEND, data);
	}

	@Override
	public boolean xsend(Map<String, Object> data) {
		return request(API_XSEND, data);
	}
	
	@Override
	public boolean multixsend(Map<String, Object> data) {
		return request(API_MULTIXSEND, data);
	}

	
}
