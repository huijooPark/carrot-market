package com.cloneproject.carrotmarket.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@ToString(exclude = {"id", "authKey"})
@Getter @Setter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "nickName", nullable = false, length = 30)
    private String nickName;

    @Column(name = "dongneaOne", nullable = true, length = 30)
    private String dongneaOne;

    @Column(name = "dongneaTwo", nullable = true, length = 30)
    private String dongneaTwo;

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


}
