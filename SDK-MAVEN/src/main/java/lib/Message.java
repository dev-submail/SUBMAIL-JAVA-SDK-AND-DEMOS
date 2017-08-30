package lib;

import java.util.Map;

import lib.base.ISender;
import lib.base.Sender;

import config.AppConfig;
/**
 * 短信api，定义发送HTTP请求消息模式。
 * @author submail
 *
 */
public class Message extends Sender {

	private static final String API_SEND = "http://api.submail.cn/message/send.json";
	private static final String API_XSEND = "http://api.submail.cn/message/xsend.json";
	private static final String API_MULTIXSEND = "http://api.submail.cn/message/multixsend.json";
	private static final String API_LOG = "http://api.submail.cn/log/message.json";
	private static final String API_TEMPLATE = "http://api.submail.cn/message/template.json";
	private static final String API_SUBSCRIBE = "http://api.submail.cn/addressbook/message/subscribe.json";
	private static final String API_UNSUBSCRIBE = "http://api.submail.cn/addressbook/message/unsubscribe.json";

	public Message(AppConfig config) {
		this.config = config;
	}
	
	/**
	 * 发送请求数据到服务器,数据由两部分组成,其中一个是原始数据，另一个是签名
	 */
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
	
	@Override
	public boolean subscribe(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_SUBSCRIBE, data);
	}

	@Override
	public boolean unsubscribe(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_UNSUBSCRIBE, data);
	}
	
	@Override
	public boolean log(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_LOG, data);
	}
	
	@Override
	public boolean get(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return getMethodRequest(API_TEMPLATE , data);
	}
	@Override
	public boolean post(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return request(API_TEMPLATE , data);
	}
	@Override
	public boolean put(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return putMethodRequest(API_TEMPLATE, data);
	}
	@Override
	public boolean delete(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return deleteMethodRequest(API_TEMPLATE , data);
	}
	
	
	
}
