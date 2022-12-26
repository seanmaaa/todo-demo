package io.kcdhbp.tododemo.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractNotFoundException extends ResponseStatusException {
  protected AbstractNotFoundException() {
    super(HttpStatus.NOT_FOUND);
  }

  protected AbstractNotFoundException(final String reason) {
    super(HttpStatus.NOT_FOUND, reason);
  }

  protected AbstractNotFoundException(final String reason, final Throwable cause) {
    super(HttpStatus.NOT_FOUND, reason, cause);
  }
}
