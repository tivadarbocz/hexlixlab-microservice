package hu.helixlab.ms.webshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoResourceException extends RuntimeException {
    public NoResourceException() {
        super();
    }

    public NoResourceException(String message) {
        super(message);
    }

    public NoResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoResourceException(Throwable cause) {
        super(cause);
    }

    protected NoResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
