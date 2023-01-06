package com.example.springwithresttemplate.service;


import com.example.springwithresttemplate.model.Person;
import com.example.springwithresttemplate.model.PersonRe;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class PersonAddressService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${new.url}")
    private String rightUrl;
    public Person getPerson(Long id) {
        Person person= restTemplate.getForObject(rightUrl+"/persons/{id}",Person.class,id);
        return person;
    }

    public PersonRe createPerson(Person person) {
        HttpEntity<Person> http=new HttpEntity<>(person);
        ResponseEntity<PersonRe> personReResponseEntity=restTemplate.exchange(rightUrl+"/persons", HttpMethod.POST,http,PersonRe.class);
        return personReResponseEntity.getBody();
    }

    public void updatePerson(Person person, Long id) {
         HttpEntity<Person> http=new HttpEntity<>(person);
        restTemplate.exchange(rightUrl+"/updatepersons/"+id,HttpMethod.PUT,http,void.class,id);
    }

    public void deleteById(Long id) {
      restTemplate.delete(rightUrl+"/persons/{id}",id);
    }
}
