package com.fifteenDaysChallenge.blogapplication.service.impl;

import com.fifteenDaysChallenge.blogapplication.entity.Post;
import com.fifteenDaysChallenge.blogapplication.exception.ResourceNotFoundException;
import com.fifteenDaysChallenge.blogapplication.payload.PostDto;
import com.fifteenDaysChallenge.blogapplication.respository.PostRepository;
import com.fifteenDaysChallenge.blogapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        return mapToDto(newPost);
    }

    @Override
    public List<PostDto> getAllPosts(){
        List<Post> posts  = postRepository.findAll();

        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            return mapToDto(post.get());
        }
        else {
            throw new ResourceNotFoundException("Post","id",id);
        }
        //OR
//        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
//        return mapToDto(post);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        Post updatedPost= postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            postRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Post","id",id);
        }
    }

    private PostDto mapToDto(Post post){
        //covert entity to DTO
        PostDto postResponse  = new PostDto();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());

        return postResponse;
    }

    private Post mapToEntity(PostDto postDto){
        //convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
