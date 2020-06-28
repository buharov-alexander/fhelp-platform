package ru.buharov.fhelp.account.dto;

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
public class AccountView {
    private Long id;
    private String name;
    private AccountTypeEnum type;
    private ValutaEnum valuta;
}
