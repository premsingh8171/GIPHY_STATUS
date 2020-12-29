package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImagesDTO implements Serializable {

	@SerializedName("original")
	private OriginalDTO original;

	@SerializedName("downsized")
	private DownsizedDTO downsized;

	@SerializedName("downsized_large")
	private DownsizedLargeDTO downsizedLarge;

	@SerializedName("downsized_medium")
	private DownsizedMediumDTO downsizedMedium;

	@SerializedName("downsized_small")
	private DownsizedSmallDTO downsizedSmall;

	@SerializedName("downsized_still")
	private DownsizedStillDTO downsizedStill;

	@SerializedName("fixed_height")
	private FixedHeightDTO fixedHeight;

	@SerializedName("fixed_height_downsampled")
	private FixedHeightDownsampledDTO fixedHeightDownsampled;

	@SerializedName("fixed_height_small")
	private FixedHeightSmallDTO fixedHeightSmall;

	@SerializedName("fixed_height_small_still")
	private FixedHeightSmallStillDTO fixedHeightSmallStill;

	@SerializedName("fixed_height_still")
	private FixedHeightStillDTO fixedHeightStill;

	@SerializedName("fixed_width")
	private FixedWidthDTO fixedWidth;

	@SerializedName("fixed_width_downsampled")
	private FixedWidthDownsampledDTO fixedWidthDownsampled;

	@SerializedName("fixed_width_small")
	private FixedWidthSmallDTO fixedWidthSmall;

	@SerializedName("fixed_width_small_still")
	private FixedWidthSmallStillDTO fixedWidthSmallStill;

	@SerializedName("fixed_width_still")
	private FixedWidthStillDTO fixedWidthStill;

	@SerializedName("looping")
	private LoopingDTO looping;

	@SerializedName("original_still")
	private OriginalStillDTO originalStill;

	@SerializedName("original_mp4")
	private OriginalMp4DTO originalMp4;

	@SerializedName("preview")
	private PreviewDTO preview;

	@SerializedName("preview_gif")
	private PreviewGifDTO previewGif;

	@SerializedName("preview_webp")
	private PreviewWebpDTO previewWebp;

	@SerializedName("hd")
	private HdDTO hd;

	@SerializedName("480w_still")
	private JsonMember480wStillDTO jsonMember480wStill;

	public void setOriginal(OriginalDTO original){
		this.original = original;
	}

	public OriginalDTO getOriginal(){
		return original;
	}

	public void setDownsized(DownsizedDTO downsized){
		this.downsized = downsized;
	}

	public DownsizedDTO getDownsized(){
		return downsized;
	}

	public void setDownsizedLarge(DownsizedLargeDTO downsizedLarge){
		this.downsizedLarge = downsizedLarge;
	}

	public DownsizedLargeDTO getDownsizedLarge(){
		return downsizedLarge;
	}

	public void setDownsizedMedium(DownsizedMediumDTO downsizedMedium){
		this.downsizedMedium = downsizedMedium;
	}

	public DownsizedMediumDTO getDownsizedMedium(){
		return downsizedMedium;
	}

	public void setDownsizedSmall(DownsizedSmallDTO downsizedSmall){
		this.downsizedSmall = downsizedSmall;
	}

	public DownsizedSmallDTO getDownsizedSmall(){
		return downsizedSmall;
	}

	public void setDownsizedStill(DownsizedStillDTO downsizedStill){
		this.downsizedStill = downsizedStill;
	}

	public DownsizedStillDTO getDownsizedStill(){
		return downsizedStill;
	}

	public void setFixedHeight(FixedHeightDTO fixedHeight){
		this.fixedHeight = fixedHeight;
	}

	public FixedHeightDTO getFixedHeight(){
		return fixedHeight;
	}

	public void setFixedHeightDownsampled(FixedHeightDownsampledDTO fixedHeightDownsampled){
		this.fixedHeightDownsampled = fixedHeightDownsampled;
	}

	public FixedHeightDownsampledDTO getFixedHeightDownsampled(){
		return fixedHeightDownsampled;
	}

	public void setFixedHeightSmall(FixedHeightSmallDTO fixedHeightSmall){
		this.fixedHeightSmall = fixedHeightSmall;
	}

	public FixedHeightSmallDTO getFixedHeightSmall(){
		return fixedHeightSmall;
	}

	public void setFixedHeightSmallStill(FixedHeightSmallStillDTO fixedHeightSmallStill){
		this.fixedHeightSmallStill = fixedHeightSmallStill;
	}

	public FixedHeightSmallStillDTO getFixedHeightSmallStill(){
		return fixedHeightSmallStill;
	}

	public void setFixedHeightStill(FixedHeightStillDTO fixedHeightStill){
		this.fixedHeightStill = fixedHeightStill;
	}

	public FixedHeightStillDTO getFixedHeightStill(){
		return fixedHeightStill;
	}

	public void setFixedWidth(FixedWidthDTO fixedWidth){
		this.fixedWidth = fixedWidth;
	}

	public FixedWidthDTO getFixedWidth(){
		return fixedWidth;
	}

	public void setFixedWidthDownsampled(FixedWidthDownsampledDTO fixedWidthDownsampled){
		this.fixedWidthDownsampled = fixedWidthDownsampled;
	}

	public FixedWidthDownsampledDTO getFixedWidthDownsampled(){
		return fixedWidthDownsampled;
	}

	public void setFixedWidthSmall(FixedWidthSmallDTO fixedWidthSmall){
		this.fixedWidthSmall = fixedWidthSmall;
	}

	public FixedWidthSmallDTO getFixedWidthSmall(){
		return fixedWidthSmall;
	}

	public void setFixedWidthSmallStill(FixedWidthSmallStillDTO fixedWidthSmallStill){
		this.fixedWidthSmallStill = fixedWidthSmallStill;
	}

	public FixedWidthSmallStillDTO getFixedWidthSmallStill(){
		return fixedWidthSmallStill;
	}

	public void setFixedWidthStill(FixedWidthStillDTO fixedWidthStill){
		this.fixedWidthStill = fixedWidthStill;
	}

	public FixedWidthStillDTO getFixedWidthStill(){
		return fixedWidthStill;
	}

	public void setLooping(LoopingDTO looping){
		this.looping = looping;
	}

	public LoopingDTO getLooping(){
		return looping;
	}

	public void setOriginalStill(OriginalStillDTO originalStill){
		this.originalStill = originalStill;
	}

	public OriginalStillDTO getOriginalStill(){
		return originalStill;
	}

	public void setOriginalMp4(OriginalMp4DTO originalMp4){
		this.originalMp4 = originalMp4;
	}

	public OriginalMp4DTO getOriginalMp4(){
		return originalMp4;
	}

	public void setPreview(PreviewDTO preview){
		this.preview = preview;
	}

	public PreviewDTO getPreview(){
		return preview;
	}

	public void setPreviewGif(PreviewGifDTO previewGif){
		this.previewGif = previewGif;
	}

	public PreviewGifDTO getPreviewGif(){
		return previewGif;
	}

	public void setPreviewWebp(PreviewWebpDTO previewWebp){
		this.previewWebp = previewWebp;
	}

	public PreviewWebpDTO getPreviewWebp(){
		return previewWebp;
	}

	public void setHd(HdDTO hd){
		this.hd = hd;
	}

	public HdDTO getHd(){
		return hd;
	}

	public void setJsonMember480wStill(JsonMember480wStillDTO jsonMember480wStill){
		this.jsonMember480wStill = jsonMember480wStill;
	}

	public JsonMember480wStillDTO getJsonMember480wStill(){
		return jsonMember480wStill;
	}

	@Override
 	public String toString(){
		return 
			"ImagesDTO{" + 
			"original = '" + original + '\'' + 
			",downsized = '" + downsized + '\'' + 
			",downsized_large = '" + downsizedLarge + '\'' + 
			",downsized_medium = '" + downsizedMedium + '\'' + 
			",downsized_small = '" + downsizedSmall + '\'' + 
			",downsized_still = '" + downsizedStill + '\'' + 
			",fixed_height = '" + fixedHeight + '\'' + 
			",fixed_height_downsampled = '" + fixedHeightDownsampled + '\'' + 
			",fixed_height_small = '" + fixedHeightSmall + '\'' + 
			",fixed_height_small_still = '" + fixedHeightSmallStill + '\'' + 
			",fixed_height_still = '" + fixedHeightStill + '\'' + 
			",fixed_width = '" + fixedWidth + '\'' + 
			",fixed_width_downsampled = '" + fixedWidthDownsampled + '\'' + 
			",fixed_width_small = '" + fixedWidthSmall + '\'' + 
			",fixed_width_small_still = '" + fixedWidthSmallStill + '\'' + 
			",fixed_width_still = '" + fixedWidthStill + '\'' + 
			",looping = '" + looping + '\'' + 
			",original_still = '" + originalStill + '\'' + 
			",original_mp4 = '" + originalMp4 + '\'' + 
			",preview = '" + preview + '\'' + 
			",preview_gif = '" + previewGif + '\'' + 
			",preview_webp = '" + previewWebp + '\'' + 
			",hd = '" + hd + '\'' + 
			",480w_still = '" + jsonMember480wStill + '\'' + 
			"}";
		}
}