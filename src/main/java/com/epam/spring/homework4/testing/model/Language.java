package com.epam.spring.homework4.testing.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "language")
@Data
@Builder
public class Language {
    private enum Name {
        ENG,
        RU,
        UA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private String name;
}
