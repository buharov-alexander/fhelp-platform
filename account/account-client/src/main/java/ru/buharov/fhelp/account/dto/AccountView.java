package ru.buharov.fhelp.account.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
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
    private UUID id;
    @NotBlank(message = "Account name is mandatory")
    private String name;
    @NotNull(message = "Account type is mandatory")
    private AccountTypeEnum type;
    @NotNull(message = "Account valuta is mandatory")
    private ValutaEnum valuta;
    private AccountStateView state;
}
