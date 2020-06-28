package ru.buharov.fhelp.account.service;

import java.util.List;
import ru.buharov.fhelp.account.dto.AccountView;

public interface AccountService {
    List<AccountView> getAccounts();
}
