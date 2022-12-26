package io.kcdhbp.tododemo.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractDuplicatedException extends ResponseStatusException {
  protected AbstractDuplicatedException() {
    super(HttpStatus.CONFLICT);
  }

  protected AbstractDuplicatedException(final String reason) {
    super(HttpStatus.CONFLICT, reason);
  }

  protected AbstractDuplicatedException(final String reason, final Throwable cause) {
    super(HttpStatus.CONFLICT, reason, cause);
  }
}
