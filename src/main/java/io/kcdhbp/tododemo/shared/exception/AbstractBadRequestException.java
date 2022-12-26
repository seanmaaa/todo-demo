package io.kcdhbp.tododemo.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractBadRequestException extends ResponseStatusException {
  protected AbstractBadRequestException() {
    super(HttpStatus.BAD_REQUEST);
  }

  protected AbstractBadRequestException(final String reason) {
    super(HttpStatus.BAD_REQUEST, reason);
  }

  protected AbstractBadRequestException(final String reason, final Throwable cause) {
    super(HttpStatus.BAD_REQUEST, reason, cause);
  }
}
