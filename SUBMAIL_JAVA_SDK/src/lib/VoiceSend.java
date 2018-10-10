package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * oice/send 是 SUBMAIL 的语音通知 API。 当使用 voice/send API 提交语音通知时，
 * SUBMAIL 会与您账户中语音通知模板进行匹配，当匹配成功后，立即进行语音呼叫。
 * @author submail
 *
 */
public class VoiceSend extends SenderWapper{
	
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String CONTENT = "content";
	
    public VoiceSend(AppConfig config) {
		
		this.config = config;
		
	}
	
	public void addTo(String to) {
		requestData.addWithComma(TO, to);;
	}
	
	public void addContent(String content){
		requestData.addWithComma(CONTENT, content);
	}

	
	@Override
	public ISender getSender() {
		return new Voice(this.config);
	}

	public String send(){
		
		return  getSender().send(requestData);
	}
	
	
}
	
	
	
	


