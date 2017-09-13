package pl.kamilj.webLibrary.service.account.command;

import pl.kamilj.webLibrary.domain.entity.Account;

public interface AccountCommandService {

    void create(Account account);
    void update(Account account);
    void delete(Long accountId);
}
