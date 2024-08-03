package com.example.bee.UrlService;

public interface Service {

    String generatShortCode(String originalurl);

    String getOriginalUrl(String shortUrl);

    Long getData(String url);
}
