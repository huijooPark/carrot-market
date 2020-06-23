package com.cloneproject.carrotmarket.domain.trade;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "trade")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@DynamicUpdate // 변경한 필드만 대응
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "mem_email", nullable = false, length = 255)
    private String mem_email;

    @Column (name= "title", nullable = false,length = 255)
    private String title;

    @Column (name = "categoryCD", nullable = false, length = 8)
    private String categoryCD;

}
