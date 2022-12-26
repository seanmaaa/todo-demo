package io.kcdhbp.tododemo.user.adapter.outbound.internal;

import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드삭제InboundPort;
import io.kcdhbp.tododemo.user.application.port.outbound.사용자데이터삭제OutboundPort;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class Todo보드OutboundAdapter implements 사용자데이터삭제OutboundPort {

  private final Todo보드삭제InboundPort 보드삭제;

  @Override
  public void 삭제(final 사용자ID 사용자ID) {
    보드삭제.전체삭제(사용자ID);
  }
}
