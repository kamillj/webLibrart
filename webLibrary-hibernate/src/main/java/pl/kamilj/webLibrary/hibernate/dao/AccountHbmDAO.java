package pl.kamilj.webLibrary.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.util.HibernateUtil;

import java.util.List;

public class AccountHbmDAO {

    public void create(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            } throw new RuntimeException("Cannot creat Account");
        }

    }

    public Account findById(Long id) {
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    public List<Account> findAll() {
        throw new UnsupportedOperationException("This operation is not yet implemented");

    }
}
