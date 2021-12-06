package com.epam.spring.homework4.testing.repository;

import com.epam.spring.homework4.testing.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    List<Answer> findAllByQuestionId(Integer questionId);

    Optional<Answer> findById(Integer id);

    @Transactional
    void removeById(Integer id);
}
