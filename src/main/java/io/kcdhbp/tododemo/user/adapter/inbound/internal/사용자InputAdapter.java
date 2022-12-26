package io.kcdhbp.tododemo.user.adapter.inbound.internal;

import io.kcdhbp.tododemo.user.application.port.inbound.사용자조회QueryPort;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class 사용자InputAdapter {

  private final 사용자조회QueryPort 사용자조회;

  public 사용자ID 조회(@NonNull final String 사용자명) {
    return 사용자조회.조회(사용자명).id();
  }

  public boolean 존재여부조회(@NonNull final 사용자ID 사용자ID) {
    return 사용자조회.존재여부(사용자ID);
  }
}
