package io.kcdhbp.tododemo.user.application.usecase;

import io.kcdhbp.tododemo.user.application.port.inbound.사용자생성InboundPort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자생성PersistencePort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자조회PersistencePort;
import io.kcdhbp.tododemo.user.domain.사용자;
import io.kcdhbp.tododemo.user.domain.사용자DuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class 사용자생성UseCase implements 사용자생성InboundPort {

  private final 사용자조회PersistencePort 사용자조회;
  private final 사용자생성PersistencePort 사용자생성;

  @Transactional
  @Override
  public 사용자 생성(final String 사용자명) {
    if (사용자조회.중복조회(사용자명)) {
      throw new 사용자DuplicatedException();
    }

    return 사용자생성.생성(사용자명);
  }
}
