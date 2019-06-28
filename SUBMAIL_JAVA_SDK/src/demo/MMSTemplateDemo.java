package demo;

import config.AppConfig;
import lib.MMSTemplate;
import utils.ConfigLoader;

public class MMSTemplateDemo {
	public static void main(String[] args) throws Exception {
		// get方法
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
		MMSTemplate submail = new MMSTemplate(config);
		// // submail.getTemplateId("w3nya3");
		// System.out.println(submail.getTemplate());

		// post方法
		// submail.postMmsTitle("张");
		// submail.postMmsSignature("【测试短信】");
		// submail.postMmsSubject("这个是测试的主题");
		// JSONObject json_image = new JSONObject();
		// json_image.put("data", StringUtil
		// .encodeBase64File("/Users/submail/Desktop/de0b5bdb3017902a7c48ffe98932d5a1.png").replaceAll("\n",
		// ""));
		// json_image.put("type", "image/png");
		// JSONObject json_content = new JSONObject();
		// json_content.put("image", json_image);
		// json_content.put("text", "这是一个测试模板");
		// JSONArray jsar = new JSONArray();
		// jsar.add(json_content);
		// System.out.println(jsar.toString());
		// submail.postMmsContent(jsar.toString());
		// submail.postTemplate();

		// put
		// submail.putTemplateId("xxx");
		// submail.putMmsTitle("xxx");
		// submail.putMmsSignature("【xxx】");
		// submail.putMmsSubject("xxx");
		// JSONObject json_image = new JSONObject();
		// json_image.put("data",
		// StringUtil.encodeBase64File("/Users/submail/Desktop/CD70C8BA-BAB6-4503-A7DB-E39F3BDA16C2.png")
		// .replaceAll("\n", ""));
		// json_image.put("type", "image/png");
		// JSONObject json_content = new JSONObject();
		// json_content.put("image", json_image);
		// json_content.put("text", "这是一个测试模板");
		// JSONArray jsar = new JSONArray();
		// jsar.add(json_content);
		// System.out.println(jsar.toString());
		// submail.putMmsContent(jsar.toString());
		// submail.putTemplate();

		// del
		submail.delTemplateId("hxHFH3");
		submail.delTemplate();

	}

}
