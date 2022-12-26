package io.kcdhbp.tododemo.user.adapter.outbound.persistence;

import io.kcdhbp.tododemo.user.adapter.outbound.persistence.dao.사용자Dao;
import io.kcdhbp.tododemo.user.adapter.outbound.persistence.dto.사용자Dto;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자삭제PersistencePort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자생성PersistencePort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자조회PersistencePort;
import io.kcdhbp.tododemo.user.domain.사용자;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import io.kcdhbp.tododemo.user.domain.사용자NotfoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class 사용자PersistenceAdapter implements 사용자조회PersistencePort, 사용자삭제PersistencePort, 사용자생성PersistencePort {

  private final 사용자Dao dao;

  @Override
  public boolean 중복조회(final String 사용자명) {
    return dao.existsBy이름(사용자명);
  }

  @Override
  public 사용자 조회(final String 사용자명) {
    return dao.findBy이름(사용자명).map(dto -> new 사용자(new 사용자ID(dto.getId()), dto.get이름())).orElseThrow(사용자NotfoundException::new);
  }

  @Override
  public boolean 존재여부조회(final 사용자ID 사용자ID) {
    return dao.existsById(사용자ID.value());
  }

  @Override
  public 사용자 조회(final 사용자ID 사용자ID) {
    return dao.findById(사용자ID.value()).map(dto -> new 사용자(new 사용자ID(dto.getId()), dto.get이름())).orElseThrow(사용자NotfoundException::new);
  }

  @Override
  public void 삭제(final 사용자ID 사용자ID) {
    dao.deleteById(사용자ID.value());
  }

  @Override
  public 사용자 생성(final String 이름) {
    final var dto = new 사용자Dto();
    dto.set이름(이름);

    final var result = dao.save(dto);
    return new 사용자(new 사용자ID(result.getId()), result.get이름());
  }
}
