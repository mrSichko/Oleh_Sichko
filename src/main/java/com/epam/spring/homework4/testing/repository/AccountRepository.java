package com.epam.spring.homework4.testing.repository;


import com.epam.spring.homework4.testing.exception.EntityNotFoundException;
import com.epam.spring.homework4.testing.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account save(Account account);

    Account findByLogin(String login) throws EntityNotFoundException;

    List<Account> findAll();

    @Transactional
    void removeByLogin(String login);
}
