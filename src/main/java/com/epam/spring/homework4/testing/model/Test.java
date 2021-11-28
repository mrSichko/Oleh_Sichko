package com.epam.spring.homework4.testing.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "test")
@Data
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String complexity;
    private int sumOfQuestions;
    private int duration;
    private String status;
    private int result;
    private Timestamp createTime;
    private int subjectId;
    private int accountId;
}
