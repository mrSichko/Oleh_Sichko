package com.epam.spring.homework4.testing.repository;

import com.epam.spring.homework4.testing.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAllByTestId(Integer testId);

    Optional<Question> findById(Integer id);

    @Transactional
    void removeById(Integer id);
}
