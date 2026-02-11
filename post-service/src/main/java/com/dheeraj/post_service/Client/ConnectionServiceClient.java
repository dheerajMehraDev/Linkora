package com.dheeraj.post_service.Client;

import com.dheeraj.post_service.Dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Component
@FeignClient(name = "connections-service" )
public interface ConnectionServiceClient {
    @GetMapping("/connections/firstdegree/{id}")
    List<PersonDto> getFirstDegreeConnectionsById(@PathVariable Long id);
}
