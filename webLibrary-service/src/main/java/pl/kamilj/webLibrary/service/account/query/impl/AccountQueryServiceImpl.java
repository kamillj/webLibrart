package pl.kamilj.webLibrary.service.account.query.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.dao.AccountHbmDAO;
import pl.kamilj.webLibrary.service.account.query.AccountQueryService;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountQueryServiceImpl implements AccountQueryService{

    private AccountHbmDAO accountHbmDAO;

    @Autowired
    public AccountQueryServiceImpl(AccountHbmDAO accountHbmDAO){
        this.accountHbmDAO = accountHbmDAO;
    }

    @Override
    public Account findById(Long id) {
        return accountHbmDAO.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountHbmDAO.findAll();
    }
}
