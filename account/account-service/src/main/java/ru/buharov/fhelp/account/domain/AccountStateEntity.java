package ru.buharov.fhelp.account.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
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
@Entity
@Table(name = "account_states")
public class AccountStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    private String comment;
    private Date modified;

    public AccountStateView convertToDto() {
        return AccountStateView.builder()
                .id(getId())
                .balance(getBalance())
                .comment(getComment())
                .modified(getModified())
                .build();
    }
}
