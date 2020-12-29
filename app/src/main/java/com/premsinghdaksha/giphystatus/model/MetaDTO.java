package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MetaDTO implements Serializable {

	@SerializedName("status")
	private int status;

	@SerializedName("msg")
	private String msg;

	@SerializedName("response_id")
	private String responseId;

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setResponseId(String responseId){
		this.responseId = responseId;
	}

	public String getResponseId(){
		return responseId;
	}

	@Override
 	public String toString(){
		return 
			"MetaDTO{" + 
			"status = '" + status + '\'' + 
			",msg = '" + msg + '\'' + 
			",response_id = '" + responseId + '\'' + 
			"}";
		}
}