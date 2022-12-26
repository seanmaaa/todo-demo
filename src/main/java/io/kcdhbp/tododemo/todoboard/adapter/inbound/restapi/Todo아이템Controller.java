package io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi;

import io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.command.아이템생성Command;
import io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.command.아이템수정Command;
import io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.view.아이템ViewModel;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템삭제InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템생성InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템수정InboundPort;
import io.kcdhbp.tododemo.todoboard.application.port.inbound.아이템조회QueryPort;
import io.kcdhbp.tododemo.todoboard.domain.Todo보드ID;
import io.kcdhbp.tododemo.todoboard.domain.아이템ID;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/v1/boards")
@RestController
public class Todo아이템Controller {

  private final 아이템조회QueryPort 아이템조회;
  private final 아이템생성InboundPort 아이템생성;
  private final 아이템수정InboundPort 아이템수정;
  private final 아이템삭제InboundPort 아이템삭제;

  @GetMapping("{사용자ID}/{보드ID}/items")
  List<아이템ViewModel> 전체조회(@PathVariable final UUID 사용자ID, @PathVariable final UUID 보드ID) {
    final var 아이템목록 = 아이템조회.전체조회(new 사용자ID(사용자ID), new Todo보드ID(보드ID));
    return 아이템목록.stream().map(아이템ViewModel::of).toList();
  }

  @PostMapping("{사용자ID}/{보드ID}/items")
  @ResponseStatus(HttpStatus.CREATED)
  아이템ViewModel 등록(@PathVariable final UUID 사용자ID, @PathVariable final UUID 보드ID, @RequestBody final 아이템생성Command command) {
    final var 아이템 = 아이템생성.추가(new 사용자ID(사용자ID), new Todo보드ID(보드ID), command.description());
    return 아이템ViewModel.of(아이템);
  }

  @PutMapping("{사용자ID}/{보드ID}/items/{아이템ID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void 수정(@PathVariable final UUID 사용자ID, @PathVariable final UUID 보드ID, @PathVariable final UUID 아이템ID, @RequestBody final 아이템수정Command command) {
    아이템수정.수정(new 사용자ID(사용자ID), new Todo보드ID(보드ID), new 아이템ID(아이템ID), command.completed());
  }

  @DeleteMapping("{사용자ID}/{보드ID}/items/{아이템ID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void 삭제(@PathVariable final UUID 사용자ID, @PathVariable final UUID 보드ID, @PathVariable final UUID 아이템ID) {
    아이템삭제.삭제(new 사용자ID(사용자ID), new Todo보드ID(보드ID), new 아이템ID(아이템ID));
  }
}
