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
    public AccountCommandServiceImpl(AccountHbmDAO accountHbmDAO) {
        this.accountHbmDAO = accountHbmDAO;
    }

    @Override
    public void create(Account account) {
        accountHbmDAO.create(account);
    }

    @Override
    public void update(Account account) {
        Account dbAccount = accountHbmDAO.findById(account.getId());
        dbAccount.setId(account.getId());
        dbAccount.setFirstName(account.getFirstName());
        dbAccount.setLastName(account.getLastName());
        dbAccount.setBirthday(account.getBirthday());
        accountHbmDAO.update(dbAccount);
    }

    @Override
    public void delete(Long accountId) {
        accountHbmDAO.delete(accountId);
    }
}
