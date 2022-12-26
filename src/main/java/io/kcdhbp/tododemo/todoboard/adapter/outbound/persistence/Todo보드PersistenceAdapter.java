package io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence;

import io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dao.Todo보드Dao;
import io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dto.Todo보드Dto;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드삭제PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드생성PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드저장PersistencePort;
import io.kcdhbp.tododemo.todoboard.application.port.outbound.Todo보드조회PersistencePort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드NotFoundException;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
class Todo보드PersistenceAdapter implements Todo보드생성PersistencePort, Todo보드조회PersistencePort, Todo보드저장PersistencePort, Todo보드삭제PersistencePort {

  private final Todo보드Dao dao;

  @Override
  public Todo보드 조회(final 사용자ID 사용자ID, final Todo보드ID 보드ID) {
    return dao.findByIdAnd소유자(보드ID.value(), 사용자ID.value())
        .map(dto -> new Todo보드(new Todo보드ID(dto.getId()), new 사용자ID(dto.get소유자()), dto.get이름()))
        .orElseThrow(Todo보드NotFoundException::new);
  }

  @Override
  public List<Todo보드> 전체조회(final 사용자ID 사용자ID) {
    return dao.findAllBy소유자(사용자ID.value()).stream()
        .map(dto -> new Todo보드(new Todo보드ID(dto.getId()), new 사용자ID(dto.get소유자()), dto.get이름()))
        .toList();
  }

  @Override
  public Todo보드 생성(final 사용자ID 사용자ID, final String 보드명) {
    final var dto = new Todo보드Dto();
    dto.set소유자(사용자ID.value());
    dto.set이름(보드명);

    final var result = dao.save(dto);
    return new Todo보드(new Todo보드ID(result.getId()), new 사용자ID(result.get소유자()), result.get이름());
  }

  @Override
  public void 저장(final Todo보드 보드) {
    final var dto = new Todo보드Dto();
    dto.setId(보드.id().value());
    dto.set소유자(보드.소유자().value());
    dto.set이름(보드.이름());

    dao.save(dto);
  }

  @Override
  public void 삭제(final 사용자ID 사용자ID, final Todo보드ID 보드ID) {
    dao.findById(보드ID.value()).ifPresentOrElse(dto -> {
      if (!dto.get소유자().equals(사용자ID.value())) {
        throw new Todo보드NotFoundException();
      }
      dao.deleteById(dto.getId());
    }, () -> {
      throw new Todo보드NotFoundException();
    });
  }

  @Override
  public void 전체삭제(final 사용자ID 사용자ID) {
    dao.deleteAllBy소유자(사용자ID.value());
  }
}
