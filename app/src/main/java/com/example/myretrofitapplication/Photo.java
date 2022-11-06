package com.example.myretrofitapplication;

public class Photo {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private Integer DrwImg;

    public Photo(int albumId, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    private String thumbnailUrl;


    public Photo(int albumId,int id,String title, String url,Integer DrwImg,String tmb){
        this.albumId = albumId;
        this.id = id;
        this.title = url;
        this.url = url;
        this.DrwImg = DrwImg;
        this.thumbnailUrl = tmb;
    }
    public Integer getDrwImg() {
        return DrwImg;
    }

    public void setDrwImg(Integer drwImg) {
        DrwImg = drwImg;
    }


    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
