package pl.kamilj.webLibrary.service.account.query;

import pl.kamilj.webLibrary.domain.entity.Account;
import java.util.List;

public interface AccountQueryService {

    Account findById(Long id);
    List<Account> findAll();
}
