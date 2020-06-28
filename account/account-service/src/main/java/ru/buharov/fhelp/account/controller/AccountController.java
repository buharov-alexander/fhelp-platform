package ru.buharov.fhelp.account.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buharov.fhelp.account.dto.AccountView;
import ru.buharov.fhelp.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(path = "list")
    public List<AccountView> getAccounts() {
        return service.getAccounts();
    }
}
