package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable {

	@SerializedName("data")
	private List<DataDTO> data;

	@SerializedName("pagination")
	private PaginationDTO pagination;

	@SerializedName("meta")
	private MetaDTO meta;

	public void setData(List<DataDTO> data){
		this.data = data;
	}

	public List<DataDTO> getData(){
		return data;
	}

	public void setPagination(PaginationDTO pagination){
		this.pagination = pagination;
	}

	public PaginationDTO getPagination(){
		return pagination;
	}

	public void setMeta(MetaDTO meta){
		this.meta = meta;
	}

	public MetaDTO getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"data = '" + data + '\'' + 
			",pagination = '" + pagination + '\'' + 
			",meta = '" + meta + '\'' + 
			"}";
		}
}