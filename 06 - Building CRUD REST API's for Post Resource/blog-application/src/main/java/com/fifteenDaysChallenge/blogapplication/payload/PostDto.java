package com.fifteenDaysChallenge.blogapplication.payload;
import lombok.Data;

//this class is used as a mediator between client req and server response, we should not provide/expose all the entity details, so here we can abstract/deduce the details we need to transfer between client and server
//DTO- data transfer object
//@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
