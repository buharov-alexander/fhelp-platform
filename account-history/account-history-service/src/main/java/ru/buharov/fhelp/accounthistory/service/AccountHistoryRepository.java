package ru.buharov.fhelp.accounthistory.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.buharov.fhelp.accounthistory.domain.AccountHistoricalStateEntity;

@Repository
interface AccountHistoryRepository extends CrudRepository<AccountHistoricalStateEntity, UUID> {

	List<AccountHistoricalStateEntity> findByAccountId(UUID accountId);
}
