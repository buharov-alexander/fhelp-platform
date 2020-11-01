package ru.buharov.fhelp.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {

    private int code;
    private String error;
    private String errorMessage;
}