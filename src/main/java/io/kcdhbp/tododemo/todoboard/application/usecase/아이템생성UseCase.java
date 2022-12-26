package io.kcdhbp.tododemo.todoboard.application.usecase;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템생성InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.사용자조회OutboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템생성PersistencePort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class 아이템생성UseCase implements 아이템생성InboundPort {

  private final 사용자조회OutboundPort 사용자조회;
  private final Todo보드조회PersistencePort 보드조회;
  private final 아이템생성PersistencePort 아이템생성;

  @Transactional
  @Override
  public 아이템 추가(final 사용자ID 사용자ID, final Todo보드ID 보드ID, final String 설명) {
    사용자조회.존재여부검증(사용자ID);
    보드조회.조회(사용자ID, 보드ID);

    return 아이템생성.등록(보드ID, 설명);
  }
}
