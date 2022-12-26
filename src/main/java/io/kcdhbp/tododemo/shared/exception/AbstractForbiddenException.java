package io.kcdhbp.tododemo.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractForbiddenException extends ResponseStatusException {
  protected AbstractForbiddenException() {
    super(HttpStatus.FORBIDDEN);
  }

  protected AbstractForbiddenException(final String reason) {
    super(HttpStatus.FORBIDDEN, reason);
  }

  protected AbstractForbiddenException(final String reason, final Throwable cause) {
    super(HttpStatus.FORBIDDEN, reason, cause);
  }
}
