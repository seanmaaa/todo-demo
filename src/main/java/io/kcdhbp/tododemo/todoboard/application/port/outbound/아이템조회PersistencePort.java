package io.kcdhbp.tododemo.todoboard.application.port.outbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;

import java.util.List;

public interface 아이템조회PersistencePort {

  아이템 조회(아이템ID 아이템ID);

  List<아이템> 전체조회(Todo보드ID 보드ID);
}
