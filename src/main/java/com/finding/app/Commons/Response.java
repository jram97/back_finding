package com.finding.app.Commons;

import java.util.List;

@SuppressWarnings("rawtypes")
public class Response {

	private int code;
	
	private Boolean ok = true;
	
	private String msg;	
	
	public Response(int code, Boolean ok, String msg) {
		super();
		this.code = code;
		this.ok = ok;
		this.msg = msg;
	}

	public Response(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Response(int code, String msg, List data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Response(int code, Boolean ok, String msg, List data) {
		this.code = code;
		this.ok = ok;
		this.msg = msg;
		this.data = data;
	}
	
	private List data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}