package ru.buharov.fhelp.account.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.buharov.fhelp.account.dto.AccountView;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AccountTypeEnum type;

    @Enumerated(EnumType.STRING)
    private ValutaEnum valuta;

    private String owner;

    @OneToOne
    @JoinColumn(name = "stateId")
    private AccountStateEntity state;

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
