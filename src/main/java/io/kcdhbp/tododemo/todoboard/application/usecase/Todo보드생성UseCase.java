package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드생성InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드생성PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class Todo보드생성UseCase implements Todo보드생성InboundPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드생성PersistencePort 보드생성;

  @Transactional
  @Override
  public Todo보드 생성(final 사용자ID 사용자ID, final String 보드명) {
    사용자조회.존재여부검증(사용자ID);

    return 보드생성.생성(사용자ID, 보드명);
  }
}
