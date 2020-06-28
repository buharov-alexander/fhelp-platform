package ru.buharov.fhelp.account.service;

import org.springframework.data.repository.CrudRepository;
import ru.buharov.fhelp.account.domain.AccountEntity;

interface AccountRepository extends CrudRepository<AccountEntity, Long> {
}