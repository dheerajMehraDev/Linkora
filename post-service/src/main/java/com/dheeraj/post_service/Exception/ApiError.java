package com.dheeraj.post_service.Exception;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data

public class ApiError{
    private String msg;
    private LocalDateTime timeStamp;
    private HttpStatusCode statusCode;

    public ApiError(){
        timeStamp = LocalDateTime.now();
    }

    ApiError(String msg , HttpStatusCode statusCode){
        this();
        this.msg = msg;
        this.statusCode = statusCode;
    }


}
