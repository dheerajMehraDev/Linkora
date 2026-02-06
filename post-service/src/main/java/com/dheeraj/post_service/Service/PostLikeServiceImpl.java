package com.dheeraj.post_service.Service;

import com.dheeraj.post_service.Entity.Post;
import com.dheeraj.post_service.Entity.PostLike;
import com.dheeraj.post_service.Exception.BadRequestException;
import com.dheeraj.post_service.Exception.ResourceNotFoundException;
import com.dheeraj.post_service.Repository.PostLikeRepository;
import com.dheeraj.post_service.Repository.PostRepository;
import com.dheeraj.post_service.Service.Interface.PostLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeServiceImpl implements PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;


    @Override
    public void likePost(Long postId, Long userId) {
        log.debug("inside like post , attempting to like the post of postId : {} " , postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post with id is not found " + postId));
        boolean exists = postLikeRepository.existsByPostIdAndUserId(postId,userId);
        if(exists)
        {
            log.debug("post is already liked");
            PostLike likedPost = postLikeRepository.findByPostIdAndUserId(postId,userId);
            log.debug("attempting to unlike the post");
            unlikePost(postId,userId,likedPost);
        }
        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);
        PostLike savedPost = postLikeRepository.save(postLike);
        log.debug("finishing the method postLike");
    }

    public void unlikePost(Long postId , Long userId , PostLike likedPost){
        postRepository.deleteById(likedPost.getId());
        log.debug("post is unliked");
    }


}
