package ru.buharov.fhelp.account.rest;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.buharov.fhelp.account.dto.ErrorDTO;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {
        List<String> messages = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(m -> messages.add(m.getDefaultMessage()));
        ex.getBindingResult().getGlobalErrors().forEach(m -> messages.add(m.getDefaultMessage()));

        ErrorDTO error = new ErrorDTO(status.value(), status.getReasonPhrase(), String.join(", ", messages));
        return handleExceptionInternal(
                ex, error, headers, status, request);
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> handleThrowable(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorDTO dto = new ErrorDTO(status.value(), status.getReasonPhrase(), ex.getLocalizedMessage());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), status, request);
    }
}