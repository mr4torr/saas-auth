package io.github.mr4torr.system.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class FieldException extends RuntimeException {
    public FieldException(String field, String message) {
        super(FieldException.concatMessage(field, message));
    }


    private static String concatMessage(String field, String message) {
        return field + "#" + message;
    }
}
