package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
import net.sf.json.JSONObject;

public class MMSTemplate extends SenderWapper {

	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String GET = "get";
	public static final String POST = "post";
	public static final String PUT = "put";
	public static final String DELETE = "delete";
	public static final String TEMPLATE_ID = "template_id";
	public static final String MMS_TITLE = "mms_title";
	public static final String MMS_SIGNATURE = "mms_signature";
	public static final String MMS_CONTENT = "mms_content";
	public static final String MMS_SUBJECT = "mms_subject";
	public static final String TEXT = "text";

	public MMSTemplate(AppConfig config) {

		this.config = config;

	}

	// get
	public void getTemplateId(String templateId) {
		requestData.addWithComma(TEMPLATE_ID, templateId);
	}

	// post
	public void postMmsTitle(String mmsTitle) {
		requestData.addWithComma(MMS_TITLE, mmsTitle);
	}

	public void postMmsSignature(String mmsSignature) {
		requestData.addWithComma(MMS_SIGNATURE, mmsSignature);
	}

	public void postMmsSubject(String mms_subject) {
		requestData.addWithComma(MMS_SUBJECT, mms_subject);
	}

	public void postMmsContent(String content) {
		requestData.addWithComma(MMS_CONTENT, content);
	}

	public void addJson(JSONObject json) {
		requestData.setVarJson(json);
	}

	// put
	public void putTemplateId(String templateId) {
		requestData.addWithComma(TEMPLATE_ID, templateId);
	}

	public void putMmsTitle(String mmsTitle) {
		requestData.addWithComma(MMS_TITLE, mmsTitle);
	}

	public void putMmsSignature(String mmsSignature) {
		requestData.addWithComma(MMS_SIGNATURE, mmsSignature);
	}

	public void putMmsSubject(String mms_subject) {
		requestData.addWithComma(MMS_SUBJECT, mms_subject);
	}

	public void putMmsContent(String content) {
		requestData.addWithComma(MMS_CONTENT, content);
	}

	// delete
	public void delTemplateId(String templateId) {
		requestData.addWithComma(TEMPLATE_ID, templateId);
	}

	@Override
	public ISender getSender() {
		return new MMS(this.config);
	}

	public String getTemplate() {
		return getSender().get(requestData);
	}

	public String postTemplate() {
		return getSender().post(requestData);
	}

	public String putTemplate() {
		return getSender().put(requestData);
	}

	public String delTemplate() {
		return getSender().delete(requestData);
	}
}
