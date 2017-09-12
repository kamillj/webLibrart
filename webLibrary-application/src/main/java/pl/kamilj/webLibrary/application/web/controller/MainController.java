package pl.kamilj.webLibrary.application.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.service.account.command.AccountCommandService;
import pl.kamilj.webLibrary.service.account.query.AccountQueryService;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @Autowired
    public MainController(AccountCommandService accountCommandService, AccountQueryService accountQueryService) {
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String welcome(Model model) {
        logger.info("is executed!");
        model.addAttribute("accounts", accountQueryService.findAll());
        model.addAttribute("accountForm", new Account());
        return "main";
    }

    @RequestMapping(value = "/account/save", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("accountForm") Account account) {
        logger.info("is executed!");
        if (account.getId() == null) {
            accountCommandService.create(account);
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/account/delete/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("id") String accountId){
        logger.info("is executed!");
        accountCommandService.delete(Long.valueOf(accountId));
        return "redirect:/main";
    }
}
