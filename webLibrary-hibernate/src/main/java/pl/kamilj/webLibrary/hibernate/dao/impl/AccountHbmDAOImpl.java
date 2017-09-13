package pl.kamilj.webLibrary.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.dao.AccountHbmDAO;
import pl.kamilj.webLibrary.hibernate.util.HibernateUtil;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AccountHbmDAOImpl implements AccountHbmDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountHbmDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
    }

    @Override
    public void update(Account account) {

        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }

    @Override
    public void delete(Long accountId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(findById(accountId));
    }

    public Account findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class, id);
        return account;
    }

    public List<Account> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Account> accounts = session.createQuery("FROM Account", Account.class).getResultList();

        return accounts;
    }
}

