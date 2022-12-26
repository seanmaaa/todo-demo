package io.kcdhbp.tododemo.todoboard.application.port.inbound;

import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import io.kcdhbp.tododemo.user.domain.사용자ID;

public interface 아이템생성InboundPort {

  아이템 추가(사용자ID 사용자ID, Todo보드ID 보드ID, String 설명);
}
