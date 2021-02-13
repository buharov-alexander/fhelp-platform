package ru.buharov.fhelp.accounthistory.dto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.buharov.fhelp.account.dto.AccountStateView;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class AccountHistoryView {

	@NotNull
	private UUID accountId;
	@NotNull
	private List<AccountStateView> states;
}
