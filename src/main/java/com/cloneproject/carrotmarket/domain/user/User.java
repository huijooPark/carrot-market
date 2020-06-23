package com.cloneproject.carrotmarket.domain.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "user")
@ToString(exclude = {"id", "authKey"})
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@DynamicUpdate // 변경한 필드만 대응
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickName", unique = true, nullable = false, length = 30)
    private String nickName;

    @Column(name = "region_1", nullable = true, length = 30)
    private String region_1;

    @Column(name = "region_2", nullable = true, length = 30)
    private String region_2;

    @Column(name = "etc", nullable = true, length = 255)
    private String etc;

    @Column(name = "authKey", nullable = true, length = 255)
    private String authKey;

    @Column(name = "authStatus", nullable = false, length = 1)
    private int authStatus;

    @CreationTimestamp
    @Column(name = "createDt", nullable = false,updatable = false)
    private LocalDateTime createDt;

    @UpdateTimestamp
    @Column(name = "updateDt", nullable = false)
    private LocalDateTime updateDt;

    @Builder
    public User( String email, String nickName, String password, String authKey ){
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.authKey = authKey;
    }

    // 회원 활성화
    public void activeJoin(){
        authStatus = 1;
    }

    // 회원 비활성화
    public void inactiveJoin(){
        authStatus = 0;
    }

}
