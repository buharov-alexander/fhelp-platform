package ru.buharov.fhelp.account.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.buharov.fhelp.account.dto.AccountView;

@Slf4j
@Component
public class AccountMessageProducer {

	@Value("${kafka.topic.account.name}")
	private String kafkaTopicAccountName;
	private KafkaTemplate<String, AccountView> kafkaTemplate;

	@Autowired
	public AccountMessageProducer(KafkaTemplate<String, AccountView> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String key, AccountView accountView) {
		log.info("Send message: {}, {}", key, accountView);
		kafkaTemplate.send(kafkaTopicAccountName, key, accountView);
	}
}