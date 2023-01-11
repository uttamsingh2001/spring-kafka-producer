package com.example.resttemplate.service;

import com.example.resttemplate.model.EmployeeRequest;
import com.example.resttemplate.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestService {

    private final RestTemplate restTemplate;
    @Autowired
    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String url="http://localhost:8090";
    public EmployeeResponse postRest(EmployeeRequest employeeRequest) {
        HttpEntity<EmployeeRequest> entity = new HttpEntity<EmployeeRequest>(employeeRequest);

//        HttpHeaders headers = new     HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity <EmployeeRequest> entity = new HttpEntity<EmployeeRequest>(employeeRequest,headers);

        EmployeeResponse  exchange = restTemplate.exchange(url + "/employees", HttpMethod.POST, entity, EmployeeResponse.class).getBody();

        return exchange;


    }

    public List<EmployeeRequest> findAll() {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity <List<EmployeeRequest>> entity = new HttpEntity<List<EmployeeRequest>>(headers);
            return restTemplate.exchange(url + "/employees", HttpMethod.GET, entity, List.class).getBody();


        }
    }

