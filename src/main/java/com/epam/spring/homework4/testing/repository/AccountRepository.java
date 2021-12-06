package com.epam.spring.homework4.testing.repository;


import com.epam.spring.homework4.testing.exception.EntityNotFoundException;
import com.epam.spring.homework4.testing.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByLogin(String login) throws EntityNotFoundException;

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    Account findByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Account a WHERE a.email = ?1")
    void removeByEmail(String email);

   @Transactional
    void removeByLogin(String login);
}
