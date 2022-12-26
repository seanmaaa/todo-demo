package io.kcdhbp.tododemo.todoboard.application.port.inbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface Todo보드수정InboundPort {

  void 수정(사용자ID 사용자ID, Todo보드ID 보드ID, String 보드명);
}
