package com.example.springwithresttemplate.service;

import com.example.springwithresttemplate.model.RestTemplateModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class RestTemplateService {
  @Autowired
  private RestTemplate restTemplate;
   @Value("${base.url}")
   private String fake;
    public RestTemplateModel getPost(Long id) {
       RestTemplateModel  restTemplateModel=restTemplate.getForObject(fake+"/posts/{id}",RestTemplateModel.class,id);
       return restTemplateModel;
    }
}
