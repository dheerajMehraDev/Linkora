package com.dheeraj.post_service.Repository;

import com.dheeraj.post_service.Entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    boolean existsByPostIdAndUserId(Long postId , Long userId);

    PostLike findByPostIdAndUserId(Long postId, Long userId);
}
