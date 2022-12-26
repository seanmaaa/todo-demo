package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;

public interface 아이템생성PersistencePort {

  아이템 등록(Todo보드ID 보드ID, String 설명);
}
