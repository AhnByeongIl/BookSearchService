package com.bi.usermgmt.repository;

import com.bi.usermgmt.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findUserByUid(String uid);
}
