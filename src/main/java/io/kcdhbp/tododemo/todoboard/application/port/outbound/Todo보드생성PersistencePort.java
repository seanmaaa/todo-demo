package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드;
import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface Todo보드생성PersistencePort {

  Todo보드 생성(사용자ID 사용자ID, String 보드명);
}
