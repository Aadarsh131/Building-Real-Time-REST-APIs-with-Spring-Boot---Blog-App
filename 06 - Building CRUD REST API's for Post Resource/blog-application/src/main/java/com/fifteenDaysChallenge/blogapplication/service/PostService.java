package com.fifteenDaysChallenge.blogapplication.service;

import com.fifteenDaysChallenge.blogapplication.entity.Post;
import com.fifteenDaysChallenge.blogapplication.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(Long id);
    PostDto updatePostById(PostDto postDto, long id);
    void deletePostById(long id);
}
