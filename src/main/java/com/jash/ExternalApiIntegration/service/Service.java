package com.jash.ExternalApiIntegration.service;

import java.util.List;
import java.util.Map;

public interface Service {
    List<Map<String,Object>> getPosts();

    Map<String,Object> getPostById(int id);

    Map<String,Object> setPost(Map<String,Object> payload);

    Map<String ,Object> updatePost(int id,Map<String,Object> payload);

    Map<String,Object> deletePost(int id);
}
