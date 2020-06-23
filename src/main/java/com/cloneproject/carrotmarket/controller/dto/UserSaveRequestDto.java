package com.cloneproject.carrotmarket.controller.dto;


import com.cloneproject.carrotmarket.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String email;
    private String nickName;
    private String password;
    private String authKey;

    @Builder
    public UserSaveRequestDto( String email, String nickName, String password ){
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .nickName(nickName)
                .password(password)
                .authKey(authKey)
                .build();
    }

    public void genAuthKey(String authKey){
        this.authKey = authKey;
    }

}
