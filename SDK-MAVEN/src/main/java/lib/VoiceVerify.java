package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * voice/verify 是 SUBMAIL 的语音验证码 API ，语音现在和短信共享发送许可。
 * @author submail
 *
 */
public class VoiceVerify extends SenderWapper{
	
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String CODE = "code";
	
    public VoiceVerify(AppConfig config) {
		
		this.config = config;
		
	}
	
	public void addTo(String to) {
		requestData.addWithComma(TO, to);;
	}
	
	
	public void addCode(String code) {
		requestData.addWithComma(CODE, code);
	}
	
	

	
	@Override
	public ISender getSender() {
		return new Voice(this.config);
	}

	public String verify(){
		return getSender().verify(requestData);
	}
	
	
}
	
	
	
	


