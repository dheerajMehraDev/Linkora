package com.linkora.connection_service.Controller;

import com.linkora.connection_service.Entity.Person;
import com.linkora.connection_service.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/connections")
@RequiredArgsConstructor
public class PersonController {


    private final PersonService personService;

    @GetMapping("/firstdegree/{id}")
    List<Person> getFirstDegreeConnectionsById(@PathVariable Long id){
        return personService.getAllFirstDegreeConnections(id);
    }
}
