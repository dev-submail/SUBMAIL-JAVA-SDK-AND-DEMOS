package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;

/**
 * message/xsend 提供完整且强大的短信发送功能，区别在于，message/xsend 无需提交短信内容和短信签名，仅需提交你在 SUBMAIL
 * MESSAGE 应用程序中创 建的短信项目的标记（请参见 获取项目或地址薄的开发者标识），并可以使用文 本变量动态的控制每封短信的内容。
 * 了解如何使用文本变量。
 * 
 * @author submail
 *
 */
public class MMSXSend extends SenderWapper {

	protected AppConfig config = null;
	public static final String ADDRESSBOOK = "addressbook";
	public static final String TO = "to";
	public static final String PROJECT = "project";
	public static final String VARS = "vars";
	public static final String LINKS = "links";

	public MMSXSend(AppConfig config) {
		this.config = config;
	}

	public void addTo(String address) {
		requestData.addWithComma(TO, address);
	}

	public void setProject(String project) {
		requestData.put(PROJECT, project);
	}

	public void addVar(String key, String val) {
		requestData.addWithJson(VARS, key, val);
	}

	@Override
	public ISender getSender() {
		return new MMS(this.config);
	}

	public String xsend() {
		return getSender().xsend(requestData);
	}
}
