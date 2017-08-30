package entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
import utils.StringUtil;

/**
 * 封装请求数据
 * @author submail
 *
 */
public class DataStore extends TreeMap<String, Object> {

	public static final String COMMA = ",";

	private static final long serialVersionUID = 1L;
	
	ArrayList<String> multi = new ArrayList<String>();
	
	JSONObject varJson= new JSONObject();
	
	JSONObject toJson= new JSONObject();

	public DataStore() {

	}

	/**
	 * 定义一个拼接模式，将数据被添加到map里。
	 * 列如
	 * <code> 
	 * addWithComma("K", "v1");
	 * addWithComma("K", "v2");
	 * </code>
	 * Then, the map is {"K", "v1, v2"}
	 * @param key is the map's key
	 * @param value is the adding data
	 * */
	public void addWithComma(String key, String value) {
		if (StringUtil.isNullOrEmpty(key))
			return;
		if (this.containsKey(key)) {
			String item = COMMA + value;
			this.put(key, this.get(key) + item);
		} else {
			this.put(key, value);
		}
	}

	/**
	 * 定义一个添加模式，数据可以被添加到map里，但显示的字符串由尖括号装饰。
	 * 列如：
	 * <code> 
	 * addWithBracket("K", "v11", "v12");
	 * addWithBracket("K", "v21", "v22");
	 * </code>
	 * Then, the map is {"K", "v11<v12>, v21<v22>"}
	 * @param key is the map's key
	 * @param left 
	 * @param right 
	 * */
	public void addWithBracket(String key, String left, String right) {
		addWithComma(key, left + "<" + right + ">");
	}

	/**
	 * 定义一个添加模式，数据可以被添加到map里
	 * 但使用json显示。
	 * For Example,
	 * <code> 
	 * addWithBracket("K", "jk1", "jv1");
	 * addWithBracket("K", "jk2", "jv2");
	 * </code>
	 * Then, the map is {"K",{"jk1":"jv1","jk2":"jv2"}
	 * @param key is the map's key
	 * @param jKey is the key of json 
	 * @param jValue is the value of json 
	 * */
	public void addWithJson(String key, String jKey, String jValue) {
		if (StringUtil.isNullOrEmpty(key))
			return;
		try {
			JSONObject json = null;
			if (this.containsKey(key)) {
				Object val = this.get(key);
				json = JSONObject.fromObject(val);
			} else {
				json = new JSONObject();
			}
			if (json != null) {
				json.put(jKey, jValue);
				this.put(key, json.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *将数据转换成json格式 
	 * @param key1
	 * @param val1
	 * @param key2
	 * @param val2
	 * @return
	 */
	public JSONObject getVarJson(String key1, String val1,String key2,String val2) {	
			   varJson.put(key1, val1);
			   varJson.put(key2, val2);
			   return varJson;
	}
	
	
	/**
	 * 将json对象放到ArrayList集合里
	 * @param Vkey
	 * @param tokey
	 * @param toval
	 * @param mkey
	 */
	public void addMulti(String Vkey,String tokey,String toval,String mkey) {
		      toJson.put(Vkey, varJson);
		      toJson.put(tokey, toval);
		      multi.add(toJson.toString());
		 if(!multi.isEmpty()){
			this.put(mkey, multi.toString());
		}
	}
	
	

	private int idx = 0;

	/**
	 * 使用递增键设置数据。
	 * For exmaple,
	 * <code>addWithIncrease("K", "v1");addWithIncrease("K", "v2");
	 * </code>
	 * Then, the map is {"K[0]", v1},{"K[1]", v2}
	 * @param key is the map's key
	 * @param value is the map's value
	 * */
	public void addWithIncrease(String key, Object value) {
		this.put(key + "[" + idx++ + "]", value);
	}
}
