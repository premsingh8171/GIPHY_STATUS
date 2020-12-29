package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OnsentDTO implements Serializable {

	@SerializedName("url")
	private String url;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"OnsentDTO{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}