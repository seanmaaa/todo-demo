package io.kcdhbp.tododemo.user.adapter.inbound.restapi;

import io.kcdhbp.tododemo.user.adapter.inbound.restapi.command.사용자등록Command;
import io.kcdhbp.tododemo.user.adapter.inbound.restapi.viewmodel.사용자ViewModel;
import io.kcdhbp.tododemo.user.application.port.inbound.사용자삭제InboundPort;
import io.kcdhbp.tododemo.user.application.port.inbound.사용자생성InboundPort;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/v1/users")
@RestController
class 사용자Controller {

  private final 사용자생성InboundPort 사용자생성;
  private final 사용자삭제InboundPort 사용자삭제;

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  사용자ViewModel 등록(@RequestBody final 사용자등록Command command) {
    final var 사용자 = 사용자생성.생성(command.user_name());
    return new 사용자ViewModel(사용자.id().value(), 사용자.이름());
  }

  @DeleteMapping("{사용자ID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void 삭제(@PathVariable final UUID 사용자ID) {
    사용자삭제.삭제(new 사용자ID(사용자ID));
  }
}
