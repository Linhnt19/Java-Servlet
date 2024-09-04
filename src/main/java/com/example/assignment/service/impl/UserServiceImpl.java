package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean checkUser(String username, String password) {
        // TODO
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql="Select u from User u";
            Query q =em.createQuery(jpql);
            List<User> list= q.getResultList();
            for (User user : list) {
                if (user.getFullname().equals(username)&&user.getPassword().equals(password)){
                    return true;
                }
            }
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql="Select u from User u";
            Query q =em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }
    @Override
    public void add(User user) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public void update(User user) {
        EntityManager em =HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public User findByID(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(User.class,id);
        }finally {
            em.close();
        }
    }

    @Override
    public void deleteByID(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            User user = em.find(User.class,id);
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public boolean isExists(String id) {
        List<User> list = findAll();
        return list.stream().anyMatch(us -> us.getId().equals(id));
    }

    @Override
    public boolean isExists2(String email) {
        List<User> list = findAll();
        return list.stream().anyMatch(us -> us.getEmail().equals(email));
    }
}
