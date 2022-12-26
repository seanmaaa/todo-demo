package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드조회QueryPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
class Todo보드조회UseCase implements Todo보드조회QueryPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드조회PersistencePort 보드목록조회;

  @Transactional(readOnly = true)
  @Override
  public Todo보드 조회(final 사용자ID 사용자ID, final Todo보드ID 보드ID) {
    사용자조회.존재여부검증(사용자ID);

    return 보드목록조회.조회(사용자ID, 보드ID);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Todo보드> 전체조회(final 사용자ID 사용자ID) {
    사용자조회.존재여부검증(사용자ID);

    return 보드목록조회.전체조회(사용자ID);
  }
}
