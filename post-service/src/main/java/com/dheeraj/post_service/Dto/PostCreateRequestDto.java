package com.dheeraj.post_service.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostCreateRequestDto {
    @NotBlank(message = "post content can not be blank")
    private String content;
}
