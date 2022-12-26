package io.kcdhbp.tododemo.todoboard.adapter.outbound.internal;

import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.user.adapter.inbound.internal.사용자InputAdapter;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import io.kcdhbp.tododemo.user.domain.사용자NotfoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class 사용자OutboundAdapter implements 사용자조회OutboundPort {

  private final 사용자InputAdapter 사용자Adapter;

  @Override
  public 사용자ID 조회(@NonNull final String 사용자명) {
    return 사용자Adapter.조회(사용자명);
  }

  @Override
  public void 존재여부검증(final 사용자ID 사용자ID) {
    if (!사용자Adapter.존재여부조회(사용자ID)) {
      throw new 사용자NotfoundException();
    }
  }
}
