package com.example.springwithresttemplate.controller;

import com.example.springwithresttemplate.model.RestTemplateModel;
import com.example.springwithresttemplate.service.RestTemplateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;
    @GetMapping(path = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestTemplateModel> getPost(@PathVariable Long id) {
        RestTemplateModel post = restTemplateService.getPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
