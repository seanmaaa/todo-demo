package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 사용자조회OutboundPort {

  사용자ID 조회(String 사용자명);

  void 존재여부검증(사용자ID 사용자ID);
}
