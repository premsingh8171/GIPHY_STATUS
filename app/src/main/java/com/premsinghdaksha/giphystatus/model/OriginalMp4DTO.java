package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OriginalMp4DTO implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("mp4_size")
	private String mp4Size;

	@SerializedName("mp4")
	private String mp4;

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

	@Override
 	public String toString(){
		return 
			"OriginalMp4DTO{" + 
			"height = '" + height + '\'' + 
			",width = '" + width + '\'' + 
			",mp4_size = '" + mp4Size + '\'' + 
			",mp4 = '" + mp4 + '\'' + 
			"}";
		}
}