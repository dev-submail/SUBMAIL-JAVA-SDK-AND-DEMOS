package lib;

import java.util.Map;

import config.AppConfig;
import lib.base.ISender;
import lib.base.Sender;

/**
 * 手机流量api定义发送HTTP请求消息模式。
 * @author submail
 *
 */
public class Mobiledata extends Sender {
	private static final String API_PACKAGE  = "http://api.submail.cn/mobiledata/package.json";
	private static final String API_TOSERVICE = "http://api.submail.cn/mobiledata/TOservice.json";
	private static final String API_CHARGE = "http://api.submail.cn/mobiledata/charge.json";
	
	public Mobiledata(AppConfig config) {
		this.config = config;
	}

	
	@Override
	public String selMobiledata(Map<String, Object> data) {
		return request(API_PACKAGE , data);
	}

	@Override
	public String toService(Map<String, Object> data) {
		return request(API_TOSERVICE, data);
	}

	@Override
	public String charge(Map<String, Object> data) {
		return request(API_CHARGE, data);
	}


}
