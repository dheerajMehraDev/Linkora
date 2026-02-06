package com.dheeraj.post_service.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class PostResponseDto {
    private Long id ;
    private Long userId;
    private String content;
    private LocalDateTime createdAt;
}
