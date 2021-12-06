package com.epam.spring.homework4.testing.repository;

import com.epam.spring.homework4.testing.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TestRepository extends JpaRepository<Test, Integer> {

    Test findByName(String name);

    @Transactional
    void removeByName(String name);
}
