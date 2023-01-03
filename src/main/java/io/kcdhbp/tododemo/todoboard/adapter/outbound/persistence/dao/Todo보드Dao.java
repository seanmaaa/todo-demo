package io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dao;

import io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dto.Todo보드Dto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Todo보드Dao extends JpaRepository<Todo보드Dto, Integer> {

  Optional<Todo보드Dto> findByIdAnd소유자(Integer id, UUID 소유자);

  List<Todo보드Dto> findAllBy소유자(UUID 소유자);

  void deleteAllBy소유자(UUID 소유자);
}
