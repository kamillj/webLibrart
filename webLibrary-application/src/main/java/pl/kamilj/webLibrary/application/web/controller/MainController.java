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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @Autowired
    public MainController(AccountCommandService accountCommandService, AccountQueryService accountQueryService) {
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
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
        if(account.getId() == null) {
            accountCommandService.create(account);
            logger.info("account created!");
        } else {
            logger.info("account will be updated!");
            accountCommandService.update(account);
            logger.info("account updated!");
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/account/edit/{id}", method = RequestMethod.GET)
    public String updateAccount(@PathVariable("id") Long accountId, Model model) {
        logger.info("is executed!");
        model.addAttribute("accountForm", accountQueryService.findById(accountId));
        model.addAttribute("accounts", accountQueryService.findAll());
        return "/main";
    }

    @RequestMapping(value = "/account/delete/{id}")
    public String deleteAccount(@PathVariable("id") Long accountId) {
        logger.info("is executed!");
        accountCommandService.delete(accountId);
        return "redirect:/main";
    }
}
