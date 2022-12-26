package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;

public interface 아이템삭제PersistencePort {
  void 삭제(Todo보드ID 보드ID, 아이템ID 아이템ID);

  void 전체삭제(Todo보드ID 보드ID);
}
