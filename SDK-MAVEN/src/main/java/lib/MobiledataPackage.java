package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * mobiledata/package 是 SUBMAIL 的手机流量包查询 API，通过 API 请求，
 * 可返回当前支持的中国移动、中国联通、中国电信三大运营商的流量包详情、单价、和 API 请求标示。
 * @author submail
 *
 */
public class MobiledataPackage extends SenderWapper{
	
	protected AppConfig config = null;
	
	public MobiledataPackage(AppConfig config) {
			
			this.config = config;
			
		}
		
	
	@Override
	public ISender getSender() {
		return new Mobiledata(this.config);
	}

	public String sel(){
		return getSender().selMobiledata(requestData);
	}
	
	
}
	
	
	
	


