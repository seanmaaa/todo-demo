package io.kcdhbp.tododemo.user.application.usecase;

import io.kcdhbp.tododemo.user.application.port.inbound.사용자조회QueryPort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자조회PersistencePort;
import io.kcdhbp.tododemo.user.domain.사용자;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
class 사용자조회UseCase implements 사용자조회QueryPort {

  private final 사용자조회PersistencePort 사용자조회;

  @Transactional(readOnly = true)
  @Override
  public 사용자 조회(final String 사용자명) {
    return 사용자조회.조회(사용자명);
  }

  @Transactional(readOnly = true)
  @Override
  public 사용자 조회(final 사용자ID 사용자ID) {
    return 사용자조회.조회(사용자ID);
  }

  @Transactional(readOnly = true)
  @Override
  public boolean 존재여부(final 사용자ID 사용자ID) {
    return 사용자조회.존재여부조회(사용자ID);
  }
}
