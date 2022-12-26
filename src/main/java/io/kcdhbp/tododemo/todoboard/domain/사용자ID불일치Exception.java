package io.kcdhbp.tododemo.todoboard.domain;

import io.kcdhbp.tododemo.shared.exception.AbstractForbiddenException;

public class 사용자ID불일치Exception extends AbstractForbiddenException {

  public 사용자ID불일치Exception() {
    super();
  }
}
