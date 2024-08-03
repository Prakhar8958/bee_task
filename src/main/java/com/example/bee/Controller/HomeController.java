package com.example.bee.Controller;


import com.example.bee.UrlService.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class HomeController {

    @Autowired
    private Service service;

  @PostMapping("/generate/{originalurl}")
  public String generateShortCode(@PathVariable String originalurl){
      return service.generatShortCode(originalurl);
  }

  @GetMapping("/gettingurl/{url}")
  public String getOriginalUrl(@PathVariable String url){
      return service.getOriginalUrl(url);
  }

  @GetMapping("/stats/{shortcode}")
  public Long getCounts(String shortcode){
      return service.getData(shortcode);
  }

}
