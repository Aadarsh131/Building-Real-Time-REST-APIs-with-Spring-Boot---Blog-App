package com.fifteenDaysChallenge.blogapplication.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus will cause spring boot to respond with specific http status code whenever this exception is thrown
@ResponseStatus(value = HttpStatus.NOT_FOUND) //is it really reqd ? YESS, very imp, else this exception on "Page not found" is not thrown
@Getter
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName,fieldName,fieldValue));//eg: `post not found with id: 1`
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
