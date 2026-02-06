package com.dheeraj.post_service.Service;

import com.dheeraj.post_service.Dto.PostCreateRequestDto;
import com.dheeraj.post_service.Dto.PostResponseDto;
import com.dheeraj.post_service.Entity.Post;
import com.dheeraj.post_service.Exception.ResourceNotFoundException;
import com.dheeraj.post_service.Repository.PostRepository;
import com.dheeraj.post_service.Service.Interface.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    @Override
    public PostResponseDto createPost(PostCreateRequestDto requestDto, Long userId) {
        Post post = modelMapper.map(requestDto,Post.class);
        post.setUserId(userId);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost,PostResponseDto.class);
    }

    @Override
    public PostResponseDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("did not found post for id " + postId)
        );
        return modelMapper.map(post, PostResponseDto.class);
    }
}
