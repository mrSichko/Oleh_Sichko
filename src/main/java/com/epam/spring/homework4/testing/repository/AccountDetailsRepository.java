package com.epam.spring.homework4.testing.repository;

import com.epam.spring.homework4.testing.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer> {

    AccountDetails findByAccountId(Integer accountId) ;

    @Transactional
    void removeByAccountId(Integer accountId);
}
