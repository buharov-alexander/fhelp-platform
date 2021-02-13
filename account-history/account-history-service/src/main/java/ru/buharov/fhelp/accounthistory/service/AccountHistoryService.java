package ru.buharov.fhelp.accounthistory.service;

import java.util.UUID;

import ru.buharov.fhelp.accounthistory.dto.AccountHistoryView;

public interface AccountHistoryService {

	AccountHistoryView findByAccountId(UUID accountId);
}
