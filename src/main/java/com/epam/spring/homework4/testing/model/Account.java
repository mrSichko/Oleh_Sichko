package com.epam.spring.homework4.testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String email;

    private String password;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "language_id")
    private int languageId;
}
