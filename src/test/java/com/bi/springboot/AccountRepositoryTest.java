package com.bi.springboot;

import com.bi.usermgmt.entity.Account;
import com.bi.usermgmt.entity.AccountRole;
import com.bi.usermgmt.repository.AccountRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@Log
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

//    @Test
    public void insertTest() {
        for(int i=0; i<100; i++) {
            Account account = Account.builder()
                    .uid("user" + i)
                    .pw("pw" + i)
                    .name("userName"+i).build();
            AccountRole role = new AccountRole();
            if(i <= 80) {
                role.setRoleName("BASIC");
            }else if(i <= 90) {
                role.setRoleName("MANAGER");
            }else {
                role.setRoleName("ADMIN");
            }
//            account.setRoles(Arrays.asList(role));
            accountRepository.save(account);
        }
    }

    @Test
    public void abtest() {
        insertTest();
//        Optional<Account> result = accountRepository.findById(85L);
//        result.ifPresent(account -> log.info("account : "+account));
        log.info("##########################\n"+accountRepository.findAll());
    }

//    @Test
    public void ddtest() {
        log.info("babbasbasdbsd testtest =============="+accountRepository.findAll());
    }

}
