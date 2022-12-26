package io.kcdhbp.tododemo.todoboard.application.port.inbound;

import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 사용자ID검증QueryPort {

  void 검증(사용자ID 사용자ID);

}
