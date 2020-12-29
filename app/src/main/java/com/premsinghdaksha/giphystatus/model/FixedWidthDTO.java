package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FixedWidthDTO implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("size")
	private String size;

	@SerializedName("url")
	private String url;

	@SerializedName("mp4_size")
	private String mp4Size;

	@SerializedName("mp4")
	private String mp4;

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

	public void setMp4Size(String mp4Size){
		this.mp4Size = mp4Size;
	}

	public String getMp4Size(){
		return mp4Size;
	}

	public void setMp4(String mp4){
		this.mp4 = mp4;
	}

	public String getMp4(){
		return mp4;
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
			"FixedWidthDTO{" + 
			"height = '" + height + '\'' + 
			",width = '" + width + '\'' + 
			",size = '" + size + '\'' + 
			",url = '" + url + '\'' + 
			",mp4_size = '" + mp4Size + '\'' + 
			",mp4 = '" + mp4 + '\'' + 
			",webp_size = '" + webpSize + '\'' + 
			",webp = '" + webp + '\'' + 
			"}";
		}
}