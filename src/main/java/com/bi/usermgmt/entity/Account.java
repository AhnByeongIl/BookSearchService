package com.bi.usermgmt.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Entity
@EqualsAndHashCode(of="uid")
@ToString
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length=50)
    private String uid;

    @Column(nullable = false, length=50)
    private String userName;

    @Column(nullable = false, length=200)
    private String pwd;


    @Builder
    public Account(String uid, String pw, String name) {
        this.uid = uid;
        this.pwd = pw;
        this.userName = name;
    }
}
