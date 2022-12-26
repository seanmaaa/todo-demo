package io.kcdhbp.tododemo.user.application.port.inbound;

import io.kcdhbp.tododemo.user.domain.사용자;

public interface 사용자생성InboundPort {

  사용자 생성(String 사용자명);
}
