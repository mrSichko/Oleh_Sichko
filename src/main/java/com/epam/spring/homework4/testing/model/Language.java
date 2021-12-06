package com.epam.spring.homework4.testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "language")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    public enum Name {
        ENG,
        RU,
        UA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Name name;
}
