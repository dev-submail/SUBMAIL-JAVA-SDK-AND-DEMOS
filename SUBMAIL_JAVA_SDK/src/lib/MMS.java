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
public class MMS extends Sender {
	private static final String API_XSEND = "http://api.submail.cn/mms/xsend.json";
	private static final String API_MULTIXSEND = "http://api.submail.cn/mms/multixsend.json";

	public MMS(AppConfig config) {
		this.config = config;
	}

	/**
	 * 发送请求数据到服务器,数据由两部分组成,其中一个是原始数据，另一个是签名
	 */

	@Override
	public String xsend(Map<String, Object> data) {
		return request(API_XSEND, data);
	}

	@Override
	public String multixsend(Map<String, Object> data) {
		return request(API_MULTIXSEND, data);
	}

}
