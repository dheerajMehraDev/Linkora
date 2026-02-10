package com.linkora.connection_service.Service;

import com.linkora.connection_service.Entity.Person;
import com.linkora.connection_service.Repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

   public List<Person> getAllFirstDegreeConnections(Long id){
        return personRepository.findFirstDegreeConnections(id);
    }

}
