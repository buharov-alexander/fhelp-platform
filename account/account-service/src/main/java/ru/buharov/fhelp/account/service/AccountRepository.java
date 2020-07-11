package ru.buharov.fhelp.account.service;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import ru.buharov.fhelp.account.domain.AccountEntity;

interface AccountRepository extends CrudRepository<AccountEntity, UUID> {
}