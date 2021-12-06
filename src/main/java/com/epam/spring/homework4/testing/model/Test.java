package com.epam.spring.homework4.testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "test")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    public enum Complexity {
        EASY,
        NORMAL,
        HARD
    }

    public enum Status {
        NEW,
        COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Complexity complexity;

    @Column(name = "sum_of_questions")
    private int sumOfQuestions;
    @Enumerated(EnumType.STRING)
    private Status status;
    private int result;

    @Column(name = "create_time")
    private Timestamp createTime;
    ;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "test" , cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Question> questionList;
}
