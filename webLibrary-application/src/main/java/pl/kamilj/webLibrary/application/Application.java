package pl.kamilj.webLibrary.application;

import pl.kamilj.webLibrary.application.util.DateUtil;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.hibernate.dao.AccountHbmDAO;
import pl.kamilj.webLibrary.hibernate.util.HibernateUtil;

import java.time.LocalDate;

public class Application {

    private AccountHbmDAO accountHbmDAO = new AccountHbmDAO();

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        Account kowalski = new Account("Jan", "Kowalski", DateUtil.convertToDate(LocalDate.of(1990, 07, 30)));
        Account nowak = new Account("Grażyna", "Nowak", DateUtil.convertToDate(LocalDate.of(1994, 06, 30)));
        Account kwiatkowski = new Account("Andrzej", "Kwiatkowski", DateUtil.convertToDate(LocalDate.of(1988, 10, 06)));
        accountHbmDAO.create(kowalski);
        accountHbmDAO.create(nowak);
        accountHbmDAO.create(kwiatkowski);

        HibernateUtil.shutdown();
    }
}
