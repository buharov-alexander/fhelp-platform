package ru.buharov.fhelp.account.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import ru.buharov.fhelp.account.dto.AccountStateView;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "account_states")
public class AccountStateEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull(message = "Account balance is mandatory")
    private Double balance = 0d;
    private String comment;
    private Date modified;

    public AccountStateEntity(AccountStateView state) {
        if (state != null) {
            balance = state.getBalance();
            comment = state.getComment();
        }
        modified = new Date();
    }

    public AccountStateView convertToDto() {
        return AccountStateView.builder()
                .id(getId())
                .balance(getBalance())
                .comment(getComment())
                .modified(getModified())
                .build();
    }
}
