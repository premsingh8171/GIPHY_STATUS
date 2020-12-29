package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PaginationDTO implements Serializable {

	@SerializedName("total_count")
	private int totalCount;

	@SerializedName("count")
	private int count;

	@SerializedName("offset")
	private int offset;

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	@Override
 	public String toString(){
		return 
			"PaginationDTO{" + 
			"total_count = '" + totalCount + '\'' + 
			",count = '" + count + '\'' + 
			",offset = '" + offset + '\'' + 
			"}";
		}
}