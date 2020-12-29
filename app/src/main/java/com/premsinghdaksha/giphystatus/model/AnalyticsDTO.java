package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AnalyticsDTO implements Serializable {

	@SerializedName("onload")
	private OnloadDTO onload;

	@SerializedName("onclick")
	private OnclickDTO onclick;

	@SerializedName("onsent")
	private OnsentDTO onsent;

	public void setOnload(OnloadDTO onload){
		this.onload = onload;
	}

	public OnloadDTO getOnload(){
		return onload;
	}

	public void setOnclick(OnclickDTO onclick){
		this.onclick = onclick;
	}

	public OnclickDTO getOnclick(){
		return onclick;
	}

	public void setOnsent(OnsentDTO onsent){
		this.onsent = onsent;
	}

	public OnsentDTO getOnsent(){
		return onsent;
	}

	@Override
 	public String toString(){
		return 
			"AnalyticsDTO{" + 
			"onload = '" + onload + '\'' + 
			",onclick = '" + onclick + '\'' + 
			",onsent = '" + onsent + '\'' + 
			"}";
		}
}