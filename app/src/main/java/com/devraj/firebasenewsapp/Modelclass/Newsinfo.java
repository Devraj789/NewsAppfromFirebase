package com.devraj.firebasenewsapp.Modelclass;

public class Newsinfo {

    String news_title, news_description, news_image, news_category;

    public Newsinfo() {

    }

    public Newsinfo(String news_title, String news_description, String news_image, String news_category) {
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_image = news_image;
        this.news_category = news_category;
    }

    public String getNews_title() {
        return news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public String getNews_image() {
        return news_image;
    }

    public String getNews_category() {
        return news_category;
    }
}
