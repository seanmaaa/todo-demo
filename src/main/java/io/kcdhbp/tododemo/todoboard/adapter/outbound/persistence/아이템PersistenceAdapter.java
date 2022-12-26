package io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence;

import io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dao.아이템Dao;
import io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dto.아이템Dto;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템삭제PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템생성PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템저장PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.아이템조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
class 아이템PersistenceAdapter implements 아이템생성PersistencePort, 아이템조회PersistencePort, 아이템저장PersistencePort, 아이템삭제PersistencePort {

  private final 아이템Dao dao;

  @Override
  public 아이템 조회(final 아이템ID 아이템ID) {
    return dao.findById(아이템ID.value())
        .map(this::convert)
        .orElseThrow(아이템NotFoundException::new);
  }

  @Override
  public List<아이템> 전체조회(final Todo보드ID 보드ID) {
    return dao.findAllBy보드Id(보드ID.value()).stream()
        .map(this::convert)
        .toList();
  }

  @Override
  public 아이템 등록(final Todo보드ID 보드ID, final String 설명) {
    final var dto = new 아이템Dto();
    dto.set보드Id(보드ID.value());
    dto.set설명(설명);
    dto.set완료여부(Boolean.FALSE);

    final var result = dao.save(dto);
    return convert(result);
  }

  @Override
  public void 저장(final 아이템 아이템) {
    final var dto = new 아이템Dto();
    dto.setId(아이템.id().value());
    dto.set보드Id(아이템.소속보드().value());
    dto.set설명(아이템.설명());
    dto.set완료여부(아이템.완료여부());

    dao.save(dto);
  }

  @Override
  public void 삭제(final Todo보드ID 보드ID, final 아이템ID 아이템ID) {
    dao.findById(아이템ID.value()).ifPresentOrElse(
        dto -> {
          if (!dto.get보드Id().equals(보드ID.value())) {
            throw new 아이템NotFoundException();
          }
          dao.deleteById(아이템ID.value());
        },
        () -> {
          throw new 아이템NotFoundException();
        }
    );
  }

  @Override
  public void 전체삭제(final Todo보드ID 보드ID) {
    dao.deleteAllBy보드Id(보드ID.value());
  }

  private 아이템 convert(@NonNull final 아이템Dto source) {
    return new 아이템(new 아이템ID(source.getId()),
        new Todo보드ID(source.get보드Id()),
        source.get설명(),
        source.get완료여부(),
        source.get등록시간(),
        source.get마지막수정일시());
  }
}
