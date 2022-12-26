package io.kcdhbp.tododemo.todoboard.adapter.inbound.internal;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드조회QueryPort;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Todo보드InputAdapter {

  private final Todo보드조회QueryPort Todo보드목록조회;

  public boolean 보드존재여부(@NonNull final 사용자ID 사용자ID) {
    return !Todo보드목록조회.전체조회(사용자ID).isEmpty();
  }
}
