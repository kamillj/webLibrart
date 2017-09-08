package pl.kamilj.webLibrary.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.util.HibernateUtil;

import java.util.List;

public class AccountHbmDAO {

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
            throw new RuntimeException("Cannot create Account");
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
            throw new RuntimeException("Cannot find Account");
        }
    }

    public List<Account> findAll() {
        throw new UnsupportedOperationException("This operation is not yet implemented");

    }
}
