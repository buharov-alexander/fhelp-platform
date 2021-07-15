package ru.buharov.fhelp.account.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import ru.buharov.fhelp.account.kafka.AccountMessageProducer;

public class AccountChangeListener implements ApplicationListener<AccountEvent> {

	@Autowired
	private AccountMessageProducer accountMessageProducer;

	@Override
	public void onApplicationEvent(AccountEvent accountEvent) {
		accountMessageProducer.sendMessage(accountEvent.getType().name(), accountEvent.getAccountView());
	}
}
