package com.premsinghdaksha.giphystatus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataDTO implements Serializable {

    @SerializedName("type")
    private String type;

    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    @SerializedName("slug")
    private String slug;

    @SerializedName("bitly_gif_url")
    private String bitlyGifUrl;

    @SerializedName("bitly_url")
    private String bitlyUrl;

    @SerializedName("embed_url")
    private String embedUrl;

    @SerializedName("username")
    private String username;

    @SerializedName("source")
    private String source;

    @SerializedName("title")
    private String title;

    @SerializedName("rating")
    private String rating;

    @SerializedName("content_url")
    private String contentUrl;

    @SerializedName("source_tld")
    private String sourceTld;

    @SerializedName("source_post_url")
    private String sourcePostUrl;

    @SerializedName("is_sticker")
    private int isSticker;

    @SerializedName("import_datetime")
    private String importDatetime;

    @SerializedName("trending_datetime")
    private String trendingDatetime;

    @SerializedName("images")
    private ImagesDTO images;

    @SerializedName("user")
    private UserDTO user;

    @SerializedName("analytics_response_payload")
    private String analyticsResponsePayload;

    @SerializedName("analytics")
    private AnalyticsDTO analytics;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setBitlyGifUrl(String bitlyGifUrl) {
        this.bitlyGifUrl = bitlyGifUrl;
    }

    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    public String getSourceTld() {
        return sourceTld;
    }

    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    public void setIsSticker(int isSticker) {
        this.isSticker = isSticker;
    }

    public int getIsSticker() {
        return isSticker;
    }

    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    public String getImportDatetime() {
        return importDatetime;
    }

    public void setTrendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
    }

    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    public void setImages(ImagesDTO images) {
        this.images = images;
    }

    public ImagesDTO getImages() {
        return images;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setAnalyticsResponsePayload(String analyticsResponsePayload) {
        this.analyticsResponsePayload = analyticsResponsePayload;
    }

    public String getAnalyticsResponsePayload() {
        return analyticsResponsePayload;
    }

    public void setAnalytics(AnalyticsDTO analytics) {
        this.analytics = analytics;
    }

    public AnalyticsDTO getAnalytics() {
        return analytics;
    }

    @Override
    public String toString() {
        return
                "DataDTO{" +
                        "type = '" + type + '\'' +
                        ",id = '" + id + '\'' +
                        ",url = '" + url + '\'' +
                        ",slug = '" + slug + '\'' +
                        ",bitly_gif_url = '" + bitlyGifUrl + '\'' +
                        ",bitly_url = '" + bitlyUrl + '\'' +
                        ",embed_url = '" + embedUrl + '\'' +
                        ",username = '" + username + '\'' +
                        ",source = '" + source + '\'' +
                        ",title = '" + title + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",content_url = '" + contentUrl + '\'' +
                        ",source_tld = '" + sourceTld + '\'' +
                        ",source_post_url = '" + sourcePostUrl + '\'' +
                        ",is_sticker = '" + isSticker + '\'' +
                        ",import_datetime = '" + importDatetime + '\'' +
                        ",trending_datetime = '" + trendingDatetime + '\'' +
                        ",images = '" + images + '\'' +
                        ",user = '" + user + '\'' +
                        ",analytics_response_payload = '" + analyticsResponsePayload + '\'' +
                        ",analytics = '" + analytics + '\'' +
                        "}";
    }
}