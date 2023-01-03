package io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi;

import io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.command.Todo보드생성Command;
import io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.command.Todo보드수정Command;
import io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.view.Todo보드ViewModel;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드삭제InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드생성InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드수정InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.Todo보드조회QueryPort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/v1/boards")
@RestController
public class Todo보드Controller {

  private final Todo보드조회QueryPort 보드조회;
  private final Todo보드생성InboundPort 보드생성;
  private final Todo보드수정InboundPort 보드수정;
  private final Todo보드삭제InboundPort 보드삭제;

  @GetMapping("{사용자ID}")
  List<Todo보드ViewModel> 전체조회(@PathVariable final UUID 사용자ID) {
    final var 보드목록 = 보드조회.전체조회(new 사용자ID(사용자ID));
    return 보드목록.stream().map(보드 -> new Todo보드ViewModel(보드.id().value(), 보드.이름())).toList();
  }

  @PostMapping("{사용자ID}")
  @ResponseStatus(HttpStatus.CREATED)
  Todo보드ViewModel 등록(@PathVariable final UUID 사용자ID, @RequestBody final Todo보드생성Command command) {
    final var 보드 = 보드생성.생성(new 사용자ID(사용자ID), command.board_name());
    return new Todo보드ViewModel(보드.id().value(), 보드.이름());
  }

  @PutMapping("{사용자ID}/{보드ID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void 수정(@PathVariable final UUID 사용자ID, @PathVariable final Integer 보드ID, @RequestBody final Todo보드수정Command command) {
    보드수정.수정(new 사용자ID(사용자ID), new Todo보드ID(보드ID), command.board_name());
  }

  @DeleteMapping("{사용자ID}/{보드ID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void 삭제(@PathVariable final UUID 사용자ID, @PathVariable final Integer 보드ID) {
    보드삭제.삭제(new 사용자ID(사용자ID), new Todo보드ID(보드ID));
  }
}
