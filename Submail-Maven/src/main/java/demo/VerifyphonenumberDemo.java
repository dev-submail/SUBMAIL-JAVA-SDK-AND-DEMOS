package demo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class VerifyphonenumberDemo {
	private static final String URL = "https://api.mysubmail.com/service/verifyphonenumber.json";

	public static void main(String[] args) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("to", "+6281xxxx");
		HttpPost httpPost = new HttpPost(URL);
		httpPost.addHeader("charset", "UTF-8");
		httpPost.setEntity(builder.build());
		try {
			CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
			HttpResponse response = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
				System.out.println(jsonStr);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
