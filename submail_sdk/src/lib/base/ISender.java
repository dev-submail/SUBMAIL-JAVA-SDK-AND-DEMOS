package lib.base;

import java.util.HashMap;
import java.util.Map;

import lib.Mail;

/**
 * 接口定义了一个方法，所有类要发送请求数据必须继承他，这些类通
 * 常被设计为通信模式或工具，无论我们选择哪种模式或工具，我们都可以发送请求。
 * @author submail
 *
 */
public interface ISender {

	/**
	 * 发送请求数据
	 * @param data{@link HashMap}
	 * @return 如果发送成功,返回true，发生错误,返回false。
	 */
	public String send(Map<String, Object> data);

	public String xsend(Map<String, Object> data);
	
	public String subscribe(Map<String, Object> data);
	
	public String unsubscribe(Map<String, Object> data);
	
	public String multixsend(Map<String, Object> data);
	
	public String verify(Map<String, Object> data);

	public String log(Map<String, Object> data);
	
	public String get(Map<String, Object> data);
	
	public String post(Map<String, Object> data);
	
	public String put(Map<String, Object> data);
	
	public String delete(Map<String, Object> data);
	
	public String selMobiledata(Map<String, Object> data);
	
	public String toService (Map<String, Object> data);
	
	public String charge(Map<String, Object> data);
	
	
	
	
	

}
