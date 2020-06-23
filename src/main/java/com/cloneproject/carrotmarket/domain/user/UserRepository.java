package com.cloneproject.carrotmarket.domain.user;

import com.cloneproject.carrotmarket.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAll();
    public Optional<User> findByEmail(String Email);
    public User findByNickName(String nickName);
    public User save(User user);

    boolean existsByEmail(String email);
    boolean existsByNickName(String NickName);
}
