package io.kcdhbp.tododemo.todoboard.domain;

import io.kcdhbp.tododemo.shared.marker.AggregateRoot;
import io.kcdhbp.tododemo.user.domain.사용자ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
@Data
public class Todo보드 implements AggregateRoot<Todo보드ID> {
  private final Todo보드ID id;
  private final 사용자ID 소유자;
  @NonNull private String 이름;
}
