package com.dheeraj.post_service.Controller;

import com.dheeraj.post_service.Client.ConnectionServiceClient;
import com.dheeraj.post_service.Config.UserContextHolder;
import com.dheeraj.post_service.Dto.PersonDto;
import com.dheeraj.post_service.Dto.PostCreateRequestDto;
import com.dheeraj.post_service.Dto.PostResponseDto;
import com.dheeraj.post_service.Service.Interface.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private  final PostService postService;
    private final ConnectionServiceClient connectionServiceClient;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody @Valid PostCreateRequestDto dto , HttpServletRequest request){
        PostResponseDto responseDto = postService.createPost(dto,1L);// TODO : add a real user id here
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPostsById(@PathVariable  Long postId){
        PostResponseDto dto  = postService.getPostById(postId);
        Long userId = UserContextHolder.getCurrentUser();
        List<PersonDto> firstDegreeConnectionsById = connectionServiceClient.getFirstDegreeConnectionsById(userId);
        // TODO : send notifications to all the connections using kafka

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getall/{userId}")
    public ResponseEntity<List<PostResponseDto>> getAllPostByUserId(@PathVariable  Long userId){
        List<PostResponseDto> posts  = postService.getAllPostByUserId(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

}
