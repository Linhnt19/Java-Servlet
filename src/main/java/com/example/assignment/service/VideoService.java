package com.example.assignment.service;

import com.example.assignment.entity.Video;

import java.util.List;

public interface VideoService {
    Video findById(String id);
    void add2(Video v);
    void update2(Video v);
    Video add(Video m);
    Video update(Video m);
    void deleteById(String id);
    List<Video> findAll();
    List<Video> search(String keyword);
    List<Video> searchFavorite(String userId, String keyword);
    boolean isExists(String id);
}
