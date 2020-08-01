package ru.buharov.fhelp.account.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buharov.fhelp.account.dto.AccountStateView;
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

    @GetMapping(path = "/{id}")
    public AccountView getAccount(@PathVariable UUID id) {
        return service.getAccount(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAccount(@PathVariable UUID id) {
        service.deleteAccount(id);
    }

    @PostMapping
    public AccountView createAccount(@RequestBody AccountView accountView) {
        return service.createAccount(accountView);
    }

    @PutMapping(path = "/{id}/state")
    public AccountView createAccount(@PathVariable UUID id, @RequestBody AccountStateView accountStateView) {
        return service.updateAccountState(id, accountStateView);
    }
}
