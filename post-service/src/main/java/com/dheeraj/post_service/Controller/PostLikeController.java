package com.dheeraj.post_service.Controller;

import com.dheeraj.post_service.Service.Interface.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> createLikeForPost(@PathVariable Long postId){
        postLikeService.likePost(postId, 1L);
        // TODO : add real userid here
        return ResponseEntity.noContent().build();
    }

}
