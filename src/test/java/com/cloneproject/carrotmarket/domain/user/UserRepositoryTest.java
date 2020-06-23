package com.cloneproject.carrotmarket.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application_test.properties")
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    public void 회원가입_불러오기(){

        //given
        String email = "gmlwnrrj@naver.com";
        String nickName = "kikiBak";
        String passWord = "abcd";
        String authKey = "1234!@#$";

        //when
        User user = userRepository.save(User.builder()
                            .email(email)
                            .nickName(nickName)
                            .authKey(authKey)
                            .password(passWord)
                            .build());


        //then
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getNickName()).isEqualTo(nickName);
    }

}
