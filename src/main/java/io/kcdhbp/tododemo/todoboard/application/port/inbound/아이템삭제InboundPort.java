package io.kcdhbp.tododemo.todoboard.application.port.inbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 아이템삭제InboundPort {

  void 삭제(사용자ID 사용자ID, Todo보드ID 보드ID, 아이템ID 아이템ID);

  void 전체삭제(사용자ID 사용자ID, Todo보드ID 보드ID);
}
