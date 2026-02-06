package com.dheeraj.post_service.Service.Interface;


import com.dheeraj.post_service.Dto.PostCreateRequestDto;
import com.dheeraj.post_service.Dto.PostResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto createPost(PostCreateRequestDto requestDto , Long userId);

    PostResponseDto getPostById(Long postId);

    List<PostResponseDto> getAllPostByUserId(Long userId);
}
