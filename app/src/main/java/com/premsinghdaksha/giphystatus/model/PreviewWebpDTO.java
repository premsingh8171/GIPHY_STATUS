package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PreviewWebpDTO implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("size")
	private String size;

	@SerializedName("url")
	private String url;

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	public void setWidth(String width){
		this.width = width;
	}

	public String getWidth(){
		return width;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"PreviewWebpDTO{" + 
			"height = '" + height + '\'' + 
			",width = '" + width + '\'' + 
			",size = '" + size + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}