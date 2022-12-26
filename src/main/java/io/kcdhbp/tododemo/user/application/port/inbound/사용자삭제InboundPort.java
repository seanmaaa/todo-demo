package io.kcdhbp.tododemo.user.application.port.inbound;

import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 사용자삭제InboundPort {

  void 삭제(사용자ID 사용자ID);
}
