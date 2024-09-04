package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    @Override
    public Video findById(String id) {
        //TODO
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Video.class,id);
        }finally {
            em.close();
        }
    }

    @Override
    public void add2(Video v) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public void update2(Video v) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(v);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public Video add(Video m) {
        //TODO
        return null;
    }

    @Override
    public Video update(Video m) {
        //TODO
        return null;
    }

    @Override
    public void deleteById(String id) {
        //TODO
        EntityManager em =HibernateUtil.createEntityManager();
        try {
            Video v =em.find(Video.class,id);
            em.getTransaction().begin();
            em.remove(v);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAll() {
        //TODO
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql ="Select v from Video v";
            Query q =em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Video> search(String keyword) {
        //TODO
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql ="Select v from Video v where v.title like :kw";
            Query q =em.createQuery(jpql);
            q.setParameter("kw", "%" + keyword + "%");
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Video> searchFavorite(String username, String keyword) {
        //TODO
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql ="Select f.video from Favorite f where f.video.title like :kw and f.user.fullname like :name";
            Query q =em.createQuery(jpql);
            q.setParameter("kw", "%" + keyword + "%");
            q.setParameter("name", username);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public boolean isExists(String id) {
        List<Video> list = findAll();
        return list.stream().anyMatch(us -> us.getId().equals(id));
    }
}
