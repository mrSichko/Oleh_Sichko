package com.epam.spring.homework4.testing.model;

import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
@Builder
public class Role {
    private enum Name{
        STUDENT,
        ADMIN;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Name name;

}
