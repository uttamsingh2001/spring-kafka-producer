package com.example.springwithresttemplate.controller;

import com.example.springwithresttemplate.model.Person;
import com.example.springwithresttemplate.model.PersonRe;
import com.example.springwithresttemplate.service.PersonAddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@Log4j2
public class PersonAddressController {
    @Autowired
    private PersonAddressService personAddressService;
    @GetMapping(path="/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Person person=personAddressService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PostMapping(path="/persons",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRe> createPerson(@RequestBody Person person){
        PersonRe personRe=personAddressService.createPerson(person);
       return new ResponseEntity<>(personRe,HttpStatus.OK);
    }

    @PutMapping(path = "/updatepersons/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePerson(@PathVariable Long id,@RequestBody Person person){
        personAddressService.updatePerson(person,id);
        return  ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
       personAddressService.deleteById(id);
        log.info("successfully deleted");
        return ResponseEntity.ok().build();
    }
}
