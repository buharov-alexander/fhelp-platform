package ru.buharov.fhelp.account.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class AccountStateView {
    private UUID id;
    @NotNull(message = "Account balance is mandatory")
    private Double balance;
    private String comment;
    private Date modified;
}
