package ru.buharov.fhelp.account.service.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.buharov.fhelp.account.dto.AccountView;

@Getter
public class AccountEvent extends ApplicationEvent {

	private AccountView accountView;
	private AccountEventType type;

	public AccountEvent(Object source, AccountView accountView, AccountEventType type) {
		super(source);
		this.accountView = accountView;
		this.type = type;
	}
}
