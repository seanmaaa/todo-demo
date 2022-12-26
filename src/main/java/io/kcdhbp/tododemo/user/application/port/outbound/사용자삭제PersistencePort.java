package io.kcdhbp.tododemo.user.application.port.outbound;

import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 사용자삭제PersistencePort {

  void 삭제(사용자ID 사용자ID);
}
