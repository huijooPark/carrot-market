package com.cloneproject.carrotmarket.service;

import com.cloneproject.carrotmarket.controller.dto.UserSaveRequestDto;
import com.cloneproject.carrotmarket.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List usersAll() throws Exception;
    public Optional userEmail(String email) throws Exception;
    public boolean existsByEmail(String email) throws Exception;
    public boolean existsByNickName(String nickName) throws Exception;
    public User join(UserSaveRequestDto userSaveRequestDto) throws Exception;
    public User userConfirm(User user) throws Exception;
    public User userMod(User user) throws Exception;
    public String userDel(String userId) throws Exception;

}
