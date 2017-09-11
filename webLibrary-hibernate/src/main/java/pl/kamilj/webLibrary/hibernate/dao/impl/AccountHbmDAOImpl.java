package pl.kamilj.webLibrary.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.dao.AccountHbmDAO;
import pl.kamilj.webLibrary.hibernate.util.HibernateUtil;

import java.util.List;

@Repository
public class AccountHbmDAOImpl implements AccountHbmDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountHbmDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Account account) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot create Account", exception);
        }
    }

    @Override
    public void delete(Long accountId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(findById(accountId));
            session.getTransaction().commit();
        } catch (Exception exception){
            throw new RuntimeException("Error when deleting Account", exception);
        }
    }

    public Account findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.getTransaction().commit();

            return account;
        } catch (Exception exception) {
            throw new RuntimeException("Error when retrieving Account", exception);
        }
    }

    public List<Account> findAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Account> accounts = session.createQuery("FROM Account", Account.class).getResultList();
            session.getTransaction().commit();

            return accounts;
        } catch (Exception exception) {
            throw new RuntimeException("Error when retrieving Accounts", exception);
        }
    }
}
