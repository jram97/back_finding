package com.finding.app.Documents.DTO;

public class MessageResponse {

	private String code;

	private Boolean ok = false;

	private String msg;

	public MessageResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public MessageResponse(String code, Boolean ok, String msg) {
		this.code = code;
		this.ok = ok;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
