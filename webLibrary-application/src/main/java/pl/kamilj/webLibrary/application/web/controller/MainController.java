package pl.kamilj.webLibrary.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kamilj.webLibrary.domain.entity.Account;
import pl.kamilj.webLibrary.service.account.command.AccountCommandService;
import pl.kamilj.webLibrary.service.account.query.AccountQueryService;


@Controller
public class MainController{

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @Autowired
    public MainController(AccountCommandService accountCommandService, AccountQueryService accountQueryService){
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("accounts", accountQueryService.findAll());
        model.addAttribute("account", new Account());
        return "main";
    }
}
