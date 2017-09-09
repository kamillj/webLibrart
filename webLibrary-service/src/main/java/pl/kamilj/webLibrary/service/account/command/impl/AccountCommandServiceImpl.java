package pl.kamilj.webLibrary.service.account.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.dao.AccountHbmDAO;
import pl.kamilj.webLibrary.service.account.command.AccountCommandService;

@Service
@Transactional
public class AccountCommandServiceImpl implements AccountCommandService {

    private AccountHbmDAO accountHbmDAO;

    @Autowired
    public AccountCommandServiceImpl(AccountHbmDAO accountHbmDAO){
        this.accountHbmDAO = accountHbmDAO;
    }

    @Override
    public void create(Account account) {
        accountHbmDAO.create(account);
    }
}
