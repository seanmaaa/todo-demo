package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템조회QueryPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
class 아이템조회UseCase implements 아이템조회QueryPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드조회PersistencePort 보드조회;
  private final 아이템조회PersistencePort 아이템조회;

  @Transactional(readOnly = true)
  @Override
  public 아이템 조회(final 사용자ID 사용자ID, final Todo보드ID 보드ID, final 아이템ID 아이템ID) {
    사용자조회.존재여부검증(사용자ID);
    보드조회.조회(사용자ID, 보드ID);

    return 아이템조회.조회(아이템ID);
  }

  @Transactional(readOnly = true)
  @Override
  public List<아이템> 전체조회(final 사용자ID 사용자ID, final Todo보드ID 보드ID) {
    사용자조회.존재여부검증(사용자ID);
    보드조회.조회(사용자ID, 보드ID);

    return 아이템조회.전체조회(보드ID);
  }
}
