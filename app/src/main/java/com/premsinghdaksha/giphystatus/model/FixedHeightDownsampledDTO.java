package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FixedHeightDownsampledDTO implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("size")
	private String size;

	@SerializedName("url")
	private String url;

	@SerializedName("webp_size")
	private String webpSize;

	@SerializedName("webp")
	private String webp;

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

	public void setWebpSize(String webpSize){
		this.webpSize = webpSize;
	}

	public String getWebpSize(){
		return webpSize;
	}

	public void setWebp(String webp){
		this.webp = webp;
	}

	public String getWebp(){
		return webp;
	}

	@Override
 	public String toString(){
		return 
			"FixedHeightDownsampledDTO{" + 
			"height = '" + height + '\'' + 
			",width = '" + width + '\'' + 
			",size = '" + size + '\'' + 
			",url = '" + url + '\'' + 
			",webp_size = '" + webpSize + '\'' + 
			",webp = '" + webp + '\'' + 
			"}";
		}
}