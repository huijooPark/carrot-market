package com.cloneproject.carrotmarket.service;

import com.cloneproject.carrotmarket.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List usersAll() throws Exception;
    public Optional user(Long userId) throws Exception;
    public User userReg(User user) throws Exception;
    public User userConfirm(User user) throws Exception;
    public User userMod(User user) throws Exception;
    public String userDel(String userId) throws Exception;

}
