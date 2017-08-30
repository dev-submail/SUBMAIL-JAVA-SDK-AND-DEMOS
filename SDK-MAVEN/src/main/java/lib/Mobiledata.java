package lib;

import java.util.Map;

import lib.base.ISender;
import lib.base.Sender;

import config.AppConfig;

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
	public boolean selMobiledata(Map<String, Object> data) {
		return request(API_PACKAGE , data);
	}

	@Override
	public boolean toService(Map<String, Object> data) {
		return request(API_TOSERVICE, data);
	}

	@Override
	public boolean charge(Map<String, Object> data) {
		return request(API_CHARGE, data);
	}


}
