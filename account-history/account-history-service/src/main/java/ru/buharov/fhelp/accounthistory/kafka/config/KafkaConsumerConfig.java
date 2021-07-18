package ru.buharov.fhelp.accounthistory.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.buharov.fhelp.account.dto.AccountView;

@Configuration
public class KafkaConsumerConfig {

	@Value("${kafka.address}")
	private String kafkaAddress;

	public ConsumerFactory<String, AccountView> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "consuming");

		DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
		Map<String, Class<?>> classMap = new HashMap<>();
		classMap.put("name.nicholasgribanov.dto.Data", AccountView.class);
		typeMapper.setIdClassMapping(classMap);
		typeMapper.addTrustedPackages("*");

		JsonDeserializer<AccountView> jsonDeserializer = new JsonDeserializer<>(AccountView.class);
		jsonDeserializer.setTypeMapper(typeMapper);
		jsonDeserializer.setUseTypeMapperForKey(true);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), jsonDeserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AccountView> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, AccountView> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}

