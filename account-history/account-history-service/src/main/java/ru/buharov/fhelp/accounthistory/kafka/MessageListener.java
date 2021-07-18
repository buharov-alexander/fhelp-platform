package ru.buharov.fhelp.accounthistory.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.buharov.fhelp.account.dto.AccountView;

@Slf4j
public class MessageListener {

	@KafkaListener(topics = "${kafka.topic.account.name}", containerFactory = "kafkaListenerContainerFactory")
	public void listener(
			AccountView accountView,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key) {
		log.info("Recieved message: {} {}", key, accountView);
	}
}