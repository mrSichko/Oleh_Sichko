package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Builder
public class TestDto {
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
