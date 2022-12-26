package io.kcdhbp.tododemo.user.domain;

import io.kcdhbp.tododemo.shared.marker.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
@Data
public class 사용자 implements AggregateRoot<사용자ID> {
  private final 사용자ID id;
  private String 이름;
}
