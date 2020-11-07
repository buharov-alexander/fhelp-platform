package ru.buharov.fhelp.account.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.buharov.fhelp.account.domain.AccountEntity;
import ru.buharov.fhelp.account.domain.AccountStateEntity;
import ru.buharov.fhelp.account.dto.AccountStateView;
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

    @Override
    public AccountView getAccount(UUID id) {
        return findById(id).convertToDto();
    }

    @Override
    @Transactional
    public AccountView createAccount(AccountView accountView) {
        return repository.save(new AccountEntity(accountView)).convertToDto();
    }

    @Override
    @Transactional
    public AccountView updateAccountState(UUID id, AccountStateView accountStateView) {
        AccountEntity account = findById(id);
        AccountStateEntity state = account.getState();
        state.setBalance(accountStateView.getBalance());
        state.setComment(accountStateView.getComment());
        state.setModified(new Date());
        return account.convertToDto();
    }

    @Override
    @Transactional
    public void deleteAccount(UUID id) {
        findById(id);
        repository.deleteById(id);
    }

    private AccountEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Account %s is not found", id)));
    }
}
