package com.example.resttemplate.controller;
import com.example.resttemplate.model.EmployeeRequest;
import com.example.resttemplate.model.EmployeeResponse;
import com.example.resttemplate.service.RestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final RestService restService;

    public RestController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping("/rests")
    public ResponseEntity<EmployeeResponse> postRest(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse=restService.postRest(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);

    }

    @GetMapping("/rests/getAll")
    public ResponseEntity<List<EmployeeRequest>> findAll() {
        List<EmployeeRequest> employeeRequests = restService.findAll();
        return new ResponseEntity<>(employeeRequests, HttpStatus.OK);

    }

}
