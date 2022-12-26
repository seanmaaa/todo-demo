package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.todoboard.domain.아이템;

public interface 아이템저장PersistencePort {

  void 저장(아이템 아이템);
}
