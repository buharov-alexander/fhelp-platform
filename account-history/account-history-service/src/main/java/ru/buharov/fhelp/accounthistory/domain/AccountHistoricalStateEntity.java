package ru.buharov.fhelp.accounthistory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import ru.buharov.fhelp.account.dto.AccountStateView;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "account_historical_states")
public class AccountHistoricalStateEntity {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;

	@NotNull(message = "Account id is mandatory")
	@Type(type = "uuid-char")
	private UUID accountId;
	@NotNull(message = "Account balance is mandatory")
	private Double balance = 0d;
	private String comment;
	private Date date;

	public AccountStateView convertToDto() {
		return AccountStateView.builder()
				.id(id)
				.balance(balance)
				.comment(comment)
				.date(date)
				.build();
	}
}
