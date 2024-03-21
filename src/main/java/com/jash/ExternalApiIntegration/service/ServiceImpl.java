package com.jash.ExternalApiIntegration.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    String baseUrl="https://jsonplaceholder.typicode.com/";

    StringBuilder stringBuilder=new StringBuilder(baseUrl);

    String POST="/posts";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Map<String, Object>> getPosts() {
        HttpEntity<Void> httpEntity=new HttpEntity<>(httpHeaders());
        String url=stringBuilder.append(POST).toString();
        val response= restTemplate.exchange(url, HttpMethod.GET,httpEntity,List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id) {
        HttpEntity<Void> httpEntity=new HttpEntity<>(httpHeaders());
        String url=stringBuilder.append(POST).append("/"+id).toString();
        val response= restTemplate.exchange(url, HttpMethod.GET,httpEntity,Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> setPost(Map<String, Object> payload) {
        HttpEntity<Map> httpEntity=new HttpEntity<>(payload,httpHeaders());
        String url=stringBuilder.append(POST).toString();
        val response= restTemplate.exchange(url, HttpMethod.POST,httpEntity,Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> updatePost(int id,Map<String,Object> payload) {
        HttpEntity<Map> httpEntity=new HttpEntity<>(payload,httpHeaders());
        String url=stringBuilder.append(POST).append("/"+id).toString();
        val response= restTemplate.exchange(url, HttpMethod.PUT,httpEntity,Map.class);
        return response.getBody();
    }

    @Override
    public Map<String,Object> deletePost(int id) {
        HttpEntity<Map> httpEntity=new HttpEntity<>(httpHeaders());
        String url=stringBuilder.append(POST).append("/"+id).toString();
        val response= restTemplate.exchange(url, HttpMethod.DELETE,httpEntity,Map.class);
        return response.getBody();
    }

    private HttpHeaders httpHeaders(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
