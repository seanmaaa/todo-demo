package io.kcdhbp.tododemo.todoboard.application.port.inbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;

import java.util.List;

public interface Todo보드조회QueryPort {

  Todo보드 조회(사용자ID 사용자ID, Todo보드ID 보드ID);
  List<Todo보드> 전체조회(사용자ID 사용자ID);
}
