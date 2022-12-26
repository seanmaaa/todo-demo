package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드수정InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드저장PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.사용자ID불일치Exception;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class Todo보드수정UseCase implements Todo보드수정InboundPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드조회PersistencePort 보드조회;
  private final Todo보드저장PersistencePort 보드저장;

  @Transactional
  @Override
  public void 수정(final 사용자ID 사용자ID, final Todo보드ID 보드ID, final String 보드명) {
    사용자조회.존재여부검증(사용자ID);

    final var 보드 = 보드조회.조회(사용자ID, 보드ID);
    if (!보드.소유자().equals(사용자ID)) {
      throw new 사용자ID불일치Exception();
    }
    보드.이름(보드명);

    보드저장.저장(보드);
  }
}
