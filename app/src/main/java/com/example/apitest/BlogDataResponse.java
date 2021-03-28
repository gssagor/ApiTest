package com.example.apitest;

import java.util.List;

public class BlogDataResponse {
    public int id;
    public int post_category_id;
    public int featured;
    public String title;
    public String thumbnail;
    public String body;
    public String created_at;
    public String updated_at;

    public BlogDataResponse(int id, int post_category_id, int featured, String title, String thumbnail, String body, String created_at, String updated_at) {
        this.id = id;
        this.post_category_id = post_category_id;
        this.featured = featured;
        this.title = title;
        this.thumbnail = thumbnail;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_category_id() {
        return post_category_id;
    }

    public void setPost_category_id(int post_category_id) {
        this.post_category_id = post_category_id;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        String newThumb= "https://bongiyo.com/storage/"+ thumbnail;
        return newThumb;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
class Root{
    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int current_page;
    public List<BlogDataResponse> data;
}
