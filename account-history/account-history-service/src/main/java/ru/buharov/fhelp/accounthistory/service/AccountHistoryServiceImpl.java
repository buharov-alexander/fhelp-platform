package ru.buharov.fhelp.accounthistory.service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import ru.buharov.fhelp.accounthistory.domain.AccountHistoricalStateEntity;
import ru.buharov.fhelp.accounthistory.dto.AccountHistoryView;

@Service
class AccountHistoryServiceImpl implements AccountHistoryService {

	private AccountHistoryRepository repository;

	public AccountHistoryServiceImpl(AccountHistoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public AccountHistoryView findByAccountId(@NotNull UUID accountId) {
		return convertToView(accountId, repository.findByAccountId(accountId));
	}

	private AccountHistoryView convertToView(UUID accountId, List<AccountHistoricalStateEntity> states) {
		return AccountHistoryView.builder()
				.accountId(accountId)
				.states(states.stream().map(AccountHistoricalStateEntity::convertToDto).collect(Collectors.toList()))
				.build();
	}
}
