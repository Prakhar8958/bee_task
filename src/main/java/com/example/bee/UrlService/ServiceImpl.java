package com.example.bee.UrlService;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.UUID;
@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 8;
    private static final SecureRandom random = new SecureRandom();
    HashMap<String,String> map=new HashMap<String,String>();
    HashMap<String,Long> counts=new HashMap<>();

    @Override
    public String generatShortCode(String originalUrl) {
        if (map.containsKey(originalUrl)) {
            return map.get(originalUrl);
        } else {
            String shortCode = helper(originalUrl);
            map.put(originalUrl, shortCode);
            map.put(shortCode, originalUrl);  // Add reverse mapping
            counts.put(originalUrl, 1L);  // Initialize count
            return shortCode;
        }


    }
    public String helper(String originalurl){
        StringBuilder shortCode = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            shortCode.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return shortCode.toString();
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        String originalUrl=map.getOrDefault(shortUrl, "Not Found");
        if(counts.containsKey(originalUrl)){
            counts.put(originalUrl,counts.get(originalUrl)+1);
        }

        return map.getOrDefault(shortUrl, "Not Found");
    }

    @Override
    public Long getData(String url) {
            return counts.get(url);
    }
}
