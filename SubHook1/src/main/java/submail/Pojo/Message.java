package submail.Pojo;

public class Message {
    private String events ;
    private String address;
    private String app;
    private String send_id;
    private String timestamp;
    private String token;
    private String signature;
    private String report;
    private String content;
    private String template_id;
    private String reason;
    
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Message [events=" + events + ", address=" + address + ", app=" + app + ", send_id=" + send_id
				+ ", timestamp=" + timestamp + ", token=" + token + ", signature=" + signature + ", report=" + report
				+ ", content=" + content + ", template_id=" + template_id + ", reason=" + reason + "]";
	}
	
	
	
    
	
	
	
	
}
