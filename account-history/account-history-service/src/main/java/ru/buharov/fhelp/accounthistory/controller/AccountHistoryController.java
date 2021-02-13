package ru.buharov.fhelp.accounthistory.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buharov.fhelp.accounthistory.dto.AccountHistoryView;
import ru.buharov.fhelp.accounthistory.service.AccountHistoryService;

@RestController
@RequestMapping("/account/history")
public class AccountHistoryController {

	private AccountHistoryService service;

	public AccountHistoryController(AccountHistoryService service) {
		this.service = service;
	}

	@GetMapping(path = "/{id}")
	public AccountHistoryView getAccount(@PathVariable UUID id) {
		return service.findByAccountId(id);
	}

}
