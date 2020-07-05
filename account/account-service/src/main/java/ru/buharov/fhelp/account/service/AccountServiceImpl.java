package ru.buharov.fhelp.account.service;

import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;
import ru.buharov.fhelp.account.domain.AccountEntity;
import ru.buharov.fhelp.account.dto.AccountView;

@Service
class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AccountView> getAccounts() {
        return ImmutableList.copyOf(repository.findAll().iterator())
                .stream()
                .map(AccountEntity::convertToDto)
                .collect(Collectors.toList());
    }
}
