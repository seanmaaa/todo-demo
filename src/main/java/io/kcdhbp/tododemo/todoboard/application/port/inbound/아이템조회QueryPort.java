package io.kcdhbp.tododemo.todoboard.application.port.inbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;

import java.util.List;

public interface 아이템조회QueryPort {

  아이템 조회(사용자ID 사용자ID, Todo보드ID 보드ID, 아이템ID 아이템ID);

  List<아이템> 전체조회(사용자ID 사용자ID, Todo보드ID 보드ID);
}
