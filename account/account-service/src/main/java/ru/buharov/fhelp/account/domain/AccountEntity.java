package ru.buharov.fhelp.account.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
import ru.buharov.fhelp.account.dto.AccountView;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(unique=true)
    @NotBlank(message = "Account name is mandatory")
    private String name;

    @NotNull(message = "Account type is mandatory")
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum type;

    @NotNull(message = "Account valuta is mandatory")
    @Enumerated(EnumType.STRING)
    private ValutaEnum valuta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stateId")
    private AccountStateEntity state;

    public AccountEntity(AccountView accountView) {
        name = accountView.getName();
        type = accountView.getType();
        valuta = accountView.getValuta();
        state = new AccountStateEntity(accountView.getState());
    }

    public AccountView convertToDto() {
        return AccountView.builder()
                .id(getId())
                .name(getName())
                .type(getType())
                .valuta(getValuta())
                .state(Optional.ofNullable(getState()).map(AccountStateEntity::convertToDto).orElse(null))
                .build();
    }
}
