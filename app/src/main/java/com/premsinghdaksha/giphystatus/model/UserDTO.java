package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDTO implements Serializable {

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("banner_image")
	private String bannerImage;

	@SerializedName("banner_url")
	private String bannerUrl;

	@SerializedName("profile_url")
	private String profileUrl;

	@SerializedName("username")
	private String username;

	@SerializedName("display_name")
	private String displayName;

	@SerializedName("description")
	private String description;

	@SerializedName("instagram_url")
	private String instagramUrl;

	@SerializedName("website_url")
	private String websiteUrl;

	@SerializedName("is_verified")
	private boolean isVerified;

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setBannerImage(String bannerImage){
		this.bannerImage = bannerImage;
	}

	public String getBannerImage(){
		return bannerImage;
	}

	public void setBannerUrl(String bannerUrl){
		this.bannerUrl = bannerUrl;
	}

	public String getBannerUrl(){
		return bannerUrl;
	}

	public void setProfileUrl(String profileUrl){
		this.profileUrl = profileUrl;
	}

	public String getProfileUrl(){
		return profileUrl;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setInstagramUrl(String instagramUrl){
		this.instagramUrl = instagramUrl;
	}

	public String getInstagramUrl(){
		return instagramUrl;
	}

	public void setWebsiteUrl(String websiteUrl){
		this.websiteUrl = websiteUrl;
	}

	public String getWebsiteUrl(){
		return websiteUrl;
	}

	public void setIsVerified(boolean isVerified){
		this.isVerified = isVerified;
	}

	public boolean isIsVerified(){
		return isVerified;
	}

	@Override
 	public String toString(){
		return 
			"UserDTO{" + 
			"avatar_url = '" + avatarUrl + '\'' + 
			",banner_image = '" + bannerImage + '\'' + 
			",banner_url = '" + bannerUrl + '\'' + 
			",profile_url = '" + profileUrl + '\'' + 
			",username = '" + username + '\'' + 
			",display_name = '" + displayName + '\'' + 
			",description = '" + description + '\'' + 
			",instagram_url = '" + instagramUrl + '\'' + 
			",website_url = '" + websiteUrl + '\'' + 
			",is_verified = '" + isVerified + '\'' + 
			"}";
		}
}