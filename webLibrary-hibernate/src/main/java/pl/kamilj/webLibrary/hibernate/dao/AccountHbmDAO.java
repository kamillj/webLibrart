package pl.kamilj.webLibrary.hibernate.dao;

import pl.kamilj.webLibrary.domain.entity.Account;
import java.util.List;

public interface AccountHbmDAO {

    void create(Account account);
    void delete(Long accountId);
    Account findById(Long id);
    List<Account> findAll();
}
