package com.jash.ExternalApiIntegration.controller;

import com.jash.ExternalApiIntegration.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/getposts")
    List<Map<String,Object>> getAllPosts(){
        return service.getPosts();
    }

    @GetMapping("/getpostbyid/{id}")
    Map<String,Object> getPostById(@PathVariable int id){
        return service.getPostById(id);
    }

    @PostMapping("/setpost")
    Map<String,Object> setPost(@RequestBody Map<String,Object> payload){
        return service.setPost(payload);
    }

    @PutMapping("/putpost/{id}")
    Map<String,Object> updatePost(@PathVariable int id,@RequestBody Map<String,Object> payload){
        return service.updatePost(id,payload);
    }

    @DeleteMapping("/deletepost/{id}")
    Map<String,Object> deletePost(@PathVariable int id){
        return service.deletePost(id);
    }
}
