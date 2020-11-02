package ca.cooperators.payload.logging.service.entity;

public class PayLoad {
	String appName;
	String requestType;
	String payload;
	String integrationName;
	Long flowID;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getIntegrationName() {
		return integrationName;
	}
	public void setIntegrationName(String integrationName) {
		this.integrationName = integrationName;
	}
	public Long getFlowID() {
		return flowID;
	}
	public void setFlowID(Long flowID) {
		this.flowID = flowID;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
