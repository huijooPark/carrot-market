package com.cloneproject.carrotmarket.repository;

import com.cloneproject.carrotmarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTableRepository extends JpaRepository<User, Long> {

    public List<User> findAll();
    public Optional<User> findByEmail(String Email);
    public User findByNickName(String nickName);
    public User findByNickNameLike(String keyWord);

    boolean existsByEmail(String email);
    boolean existsByNickName(String NickName);
}
