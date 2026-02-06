package com.dheeraj.post_service.Controller;

import com.dheeraj.post_service.Dto.PostCreateRequestDto;
import com.dheeraj.post_service.Dto.PostResponseDto;
import com.dheeraj.post_service.Service.Interface.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private  final PostService postService;


    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody @Valid PostCreateRequestDto dto , HttpServletRequest request){
        PostResponseDto responseDto = postService.createPost(dto,1L);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPostsById(@PathVariable  Long postId){
        PostResponseDto dto  = postService.getPostById(postId);
        return ResponseEntity.ok(dto);
    }

}
