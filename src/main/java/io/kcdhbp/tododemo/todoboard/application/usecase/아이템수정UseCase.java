package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템수정InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템저장PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class 아이템수정UseCase implements 아이템수정InboundPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드조회PersistencePort 보드조회;
  private final 아이템조회PersistencePort 아이템조회;
  private final 아이템저장PersistencePort 아이템저장;

  @Transactional
  @Override
  public void 수정(final 사용자ID 사용자ID, final Todo보드ID 보드ID, final 아이템ID 아이템ID, final Boolean 완료여부) {
    사용자조회.존재여부검증(사용자ID);
    보드조회.조회(사용자ID, 보드ID);

    final var 아이템 = 아이템조회.조회(아이템ID);
    아이템.완료여부(완료여부);

    아이템저장.저장(아이템);
  }
}
