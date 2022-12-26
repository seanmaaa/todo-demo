package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드;

public interface Todo보드저장PersistencePort {

  void 저장(Todo보드 보드);
}
