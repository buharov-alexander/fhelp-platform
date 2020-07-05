package ru.buharov.fhelp.account.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.buharov.fhelp.account.domain.AccountTypeEnum;
import ru.buharov.fhelp.account.domain.ValutaEnum;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class AccountStateView {
    private Long id;
    private Double balance;
    private String comment;
    private Date modified;
}
