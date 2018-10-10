package lib;

import java.util.Map;

import config.AppConfig;
import lib.base.Sender;

/**
 * 短信api，定义发送HTTP请求消息模式。
 * 
 * @author submail
 *
 */
public class Voice extends Sender {

	private static final String API_SEND = "http://api.submail.cn/voice/send.json";
	private static final String API_XSEND = "http://api.submail.cn/voice/xsend.json";
	private static final String API_MULTIXSEND = "http://api.submail.cn/voice/multixsend.json";
	private static final String API_VERIFY = "http://api.submail.cn/voice/verify.json";
	private static final String API_BALANCE = "http://api.mysubmail.com/balance/voice.json";

	public Voice(AppConfig config) {
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
	public String verify(Map<String, Object> data) {
		return request(API_VERIFY, data);
	}

	@Override
	public String balance(Map<String, Object> data) {
		return request(API_BALANCE, data);
	}

}
