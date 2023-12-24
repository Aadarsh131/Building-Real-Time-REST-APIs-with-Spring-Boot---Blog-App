package com.fifteenDaysChallenge.blogapplication.respository;

import com.fifteenDaysChallenge.blogapplication.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
