package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * Voice/xsend 是 SUBMAIL 的语音通知 API。
 * @author submail
 *
 */
public class VoiceXSend extends SenderWapper{

	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String PROJECT = "project";
	public static final String VARS = "vars";
	
    public VoiceXSend(AppConfig config) {
		
		this.config = config;
		
	}
	
	public void addTo(String to) {
		requestData.addWithComma(TO, to);;
	}
	
	
	public void addProject(String project) {
		requestData.addWithComma(PROJECT, project);;
	}
	
	public void addVars(String key,String val){
		requestData.addWithJson(VARS,key,val);
	}

	
	@Override
	public ISender getSender() {
		return new Voice(this.config);
	}

	public String xsend(){
		return getSender().xsend(requestData);
	}
	
	
}
	
	
	
	


