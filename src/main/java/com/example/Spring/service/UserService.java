package com.example.Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Spring.domain.User;

@Service
public interface UserService {
    public List<User> getUserList();
  
    
    public User findUserById(long id);
 

    public void save(User user);


    public void edit(User user);


    public void delete(Long id);

}
