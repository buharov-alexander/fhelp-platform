package ru.buharov.fhelp.account.service;

import java.util.List;
import java.util.UUID;
import ru.buharov.fhelp.account.dto.AccountStateView;
import ru.buharov.fhelp.account.dto.AccountView;

public interface AccountService {
    List<AccountView> getAccounts();

    AccountView getAccount(UUID id);

    AccountView createAccount(AccountView accountView);

    AccountView updateAccountState(UUID id, AccountStateView accountStateView);

    void deleteAccount(UUID id);
}
