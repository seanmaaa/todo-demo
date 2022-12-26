package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드삭제InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드삭제PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템삭제PersistencePort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class Todo보드삭제UseCase implements Todo보드삭제InboundPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드조회PersistencePort 보드조회;
  private final Todo보드삭제PersistencePort 보드삭제;
  private final 아이템삭제PersistencePort 아이템삭제;

  @Transactional
  @Override
  public void 삭제(final 사용자ID 사용자ID, final Todo보드ID 보드ID) {
    사용자조회.존재여부검증(사용자ID);

    아이템삭제.전체삭제(보드ID);
    보드삭제.삭제(사용자ID, 보드ID);
  }

  @Transactional
  @Override
  public void 전체삭제(final 사용자ID 사용자ID) {
    사용자조회.존재여부검증(사용자ID);

    final var 보드목록 = 보드조회.전체조회(사용자ID);
    보드목록.forEach(보드 -> 아이템삭제.전체삭제(보드.id()));
    보드삭제.전체삭제(사용자ID);
  }
}
