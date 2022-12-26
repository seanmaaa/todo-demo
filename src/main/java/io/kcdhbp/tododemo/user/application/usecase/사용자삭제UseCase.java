package io.kcdhbp.tododemo.user.application.usecase;

import io.kcdhbp.tododemo.user.application.port.inbound.사용자삭제InboundPort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자데이터삭제OutboundPort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자삭제PersistencePort;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class 사용자삭제UseCase implements 사용자삭제InboundPort {

  private final 사용자데이터삭제OutboundPort 사용자데이터삭제;
  private final 사용자삭제PersistencePort 사용자삭제;

  @Transactional
  @Override
  public void 삭제(final 사용자ID 사용자ID) {
    사용자데이터삭제.삭제(사용자ID);
    사용자삭제.삭제(사용자ID);
  }
}
