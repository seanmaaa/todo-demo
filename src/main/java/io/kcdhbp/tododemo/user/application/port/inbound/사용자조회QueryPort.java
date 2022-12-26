package io.kcdhbp.tododemo.user.application.port.inbound;

import io.kcdhbp.tododemo.user.domain.사용자;
import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 사용자조회QueryPort {

  사용자 조회(String 사용자명);

  사용자 조회(사용자ID 사용자ID);

  boolean 존재여부(사용자ID 사용자ID);
}
