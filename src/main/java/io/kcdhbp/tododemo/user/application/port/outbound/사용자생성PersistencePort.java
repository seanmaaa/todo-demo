package io.kcdhbp.tododemo.user.application.port.outbound;

import io.kcdhbp.tododemo.user.domain.사용자;

public interface 사용자생성PersistencePort {

  사용자 생성(String 이름);
}
