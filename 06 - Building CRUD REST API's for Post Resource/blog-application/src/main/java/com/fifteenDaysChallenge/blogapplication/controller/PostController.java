package com.fifteenDaysChallenge.blogapplication.controller;


import com.fifteenDaysChallenge.blogapplication.entity.Post;
import com.fifteenDaysChallenge.blogapplication.payload.PostDto;
import com.fifteenDaysChallenge.blogapplication.service.PostService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController //it internally has @ResponseBody, which helps in converting java object to json
                // for MVC we should use @Controller, for rest api's we must use @RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    //no need to annotate with @Autowired for single ctor, for ctor injection
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postDto1  = postService.createPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> postDtoList = postService.getAllPosts();
        return ResponseEntity.ok(postDtoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable long id){
        return new ResponseEntity<>(postService.updatePostById(postDto,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePostById(@PathVariable long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("post deleted successfully!!", HttpStatus.OK);
    }
}
